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
    //X and Y coordinates will be on a large grid and range from 0 to 10000.
    
    public Map() {
        cities = new ArrayList<City>();
        int cityCount = 10 + (int) (Math.random() * 10);
        for (int i = 0 ; i < cityCount ; i++) {
            addCity();
        }
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
    
    public void drawMap(Graphics g, Mouse m, MouseWheel mw, Keyboard kb) {
        for (int i = 0 ; i < 10000 ; i += 100) { 
            line(i, 0, i, 10000, g);
            line(0, i, 10000, i, g);
        }
        for (int i = 0 ; i < cities.size() ; i++) {
            fill(0, 0, 0, g);
            ellipse((int) cities.get(i).xcoord, (int) cities.get(i).ycoord, (int) (cities.get(i).population / 10000), (int) (cities.get(i).population / 10000), g);
        }
        scl = Math.pow(1.01, -mw.level);
        System.out.println(scl);
    }
    
    public String toString() {
        String ret = "CITIES:\n";
        for (int i = 0 ; i < cities.size() ; i++) {
            ret += cities.get(i) + "\n";
        }
        return ret;
    }
}