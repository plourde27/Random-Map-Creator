import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.Math.*;

public class Display extends JComponent{
    
    int tx = 0;
    int ty = 0;
    int ang = 0;
    Game game;
    Mouse mouse;
    Keyboard kb;
    
    public Display(Game g, Mouse m, Keyboard k) {
        game = g;
        mouse = m;
        kb = k;
    }
    
    
    
    public void draw(){
        super.repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        rect(200, 200, 400, 400, g);
        fill(0, 0, 255, g);
        text("Program", 400, 700, g);
        
    }
    
    public int[] transform(int x, int y) {
        x = (x - tx) / ((double) Math.cos(ang * (Math.PI / 180)));
        y = y - ty;
        int oang = Math.atan(((double) ((y - ty) / (x - tx))) * (180.0 / Math.PI));
        oang += ang;
        int dist = (int) Math.sqrt((int) (x * x + y * y));
        x = (int) (dist * Math.cos(oang));
        y = (int) (dist * Math.sin(oang));
        return new int[]{x, y};
    }
    
    public void rect(int x, int y, int w, int h, Graphics g) {
        x = transform(x, y)[0];
        y = transform(x, y)[1];
        g.fillRect(x - w / 2, y - h / 2, w, h);
    }
    
    public void ellpise(int x, int y, int w, int h, Graphics g) {
        x = transform(x, y)[0];
        y = transform(x, y)[1];
        g.fillOval(x - w / 2, y - h / 2, w, h);
    }
    
    public void fill(int r, int g, int b, Graphics gr) {
        gr.setColor(new Color((double) r, (double) g, (double) b));
    }
    
    public void fontSize(int sz, Graphics g) {
        g.setFont(new Font("Avenir", Font.PLAIN, sz));
    }
    
    public void text(String txt, int x, int y, Graphics g) {
        x = transform(x, y)[0];
        y = transform(x, y)[1];
        g.drawString(txt, x, y);
    }
}