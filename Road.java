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

public class Road extends drawInterface {
    int roadNumber;
    int[][] coords;
    
    public Road(int n, int[][] c) {
        roadNumber = n;
        coords = c;
    }
    
    public void drawRoad(Graphics g) {
        fill(200, 125, 0, g);
        vertex(300, 300);
        vertex(600, 600);
        vertex(400, 700);
        endShape(g);
    }
}