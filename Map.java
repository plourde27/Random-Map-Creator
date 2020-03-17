import java.util.*;
import java.lang.Math.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.Math.*;

public class Map extends drawInterface {
    private ArrayList<City> cities; 
    final int DISTANCE_AWAY = 300;
    int omw = 1;
    ArrayList<Road> roads = new ArrayList<Road>();
    //X and Y coordinates will be on a large grid and range from 0 to 10000.
    
    public Map() {
        cities = new ArrayList<City>();
        int cityCount = 10 + (int) (Math.random() * 10);
        for (int i = 0 ; i < cityCount ; i++) {
            addCity();
        }
        roads.add(new Road(27, new int[][]{{0, 0}, {500, 500}}));
    }
    
    public void addCity() {
        int x = (int) (Math.random() * 10000);
        int y = (int) (Math.random() * 10000);
        while (findNearestCityDistance(x, y) <= DISTANCE_AWAY) {
            x = (int) (Math.random() * 10000);
            y = (int) (Math.random() * 10000);
        }
        
        //Cities' populations must be greater than 100,000. Anything smaller is a Town
        long pop = 100000 + (int) Math.pow((int) (Math.random() * 1000), 2);
        
        cities.add(new City(pop, x, y));
    }
    
    public double findNearestCityDistance(int x, int y) {
        double m = 10000000;
        for (int i = 0 ; i < cities.size() ; i++) {
            m = Math.min(m, cities.get(i).dist(x, y));
        }
        return m;
    }
    
    public void drawMap(Graphics g, Mouse m, MoveMouse mm, MouseWheel mw, Keyboard kb) {
        fill(200, 200, 200, g);
        //for (int i = 0 ; i < 10000 ; i += 100) { 
            //line(i, 0, i, 10000, g);
            //line(0, i, 10000, i, g);
        //}
        for (int i = 0 ; i < cities.size() ; i++) {
            fill(0, 0, 0, g);
            ellipse((int) cities.get(i).xcoord, (int) cities.get(i).ycoord, (int) (cities.get(i).population / 3000), (int) (cities.get(i).population / 3000), g);
            textSize(15, g);
            text(cities.get(i).name.toString(), (int) cities.get(i).xcoord, (int) cities.get(i).ycoord, g);
        }
        
        if (mw.level > omw) {
            
            //System.out.println(coords[0] + " " + coords[1] + " " + m.x + " " + scl);
            scl *= 1.03;
            coords[0] += mm.x * 0.03 * (1.0 / scl);
            coords[1] += mm.y * 0.03 * (1.0 / scl);
        }
        else if (mw.level < omw) {
            
            scl *= 0.97;
            coords[0] -= mm.x * 0.03 * (1.0 / scl);
            coords[1] -= mm.y * 0.03 * (1.0 / scl);
        }
        System.out.println(coords[0] + (int) ((1080.0 / scl)));
        //System.out.println(coords[0] + " " + coords[1]);
        omw = mw.level;
        
        roads.get(0).drawRoad(g);
    }
    
    public String toString() {
        String ret = "CITIES:\n";
        for (int i = 0 ; i < cities.size() ; i++) {
            ret += cities.get(i) + "\n";
        }
        return ret;
    }
}