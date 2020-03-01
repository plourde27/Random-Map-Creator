import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.Math.*;

public class drawInterface extends JComponent {
    
    int tx = 0;
    int ty = 0;
    int scl = 1;
    int ang = 0;
    
    public drawInterface() {
        
    }
    
    public void repaint() {
        super.repaint();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    public int[] transform(int x, int y) {
        x = (int) ((x - tx) / ((double) Math.cos(ang * (Math.PI / 180))));
        y = y - ty;
        if (x - tx == 0) {
            x += 1;
        }
        int oang = (int) (Math.atan(((y - ty) / (x - tx))) * (180.0 / Math.PI));
        oang += ang;
        int dist = (int) Math.sqrt((int) (x * x + y * y));
        x = (int) (dist * scl * Math.cos(oang * (Math.PI / 180)));
        y = (int) (dist * scl * Math.sin(oang * (Math.PI / 180)));
        return new int[]{x, y};
    }
    
    public void rect(int x, int y, int w, int h, Graphics g) {
        System.out.println(x + " " + y);
        int ox = x;
        int oy = y;
        x = transform(ox, oy)[0];
        y = transform(ox, oy)[1];
        System.out.println(x + " " + y);
        g.fillRect(x - w / 2, y - h / 2, w, h);
    }
    
    public void ellipse(int x, int y, int w, int h, Graphics g) {
        x = transform(x, y)[0];
        y = transform(x, y)[1];
        g.fillOval(x - w / 2, y - h / 2, w, h);
    }
    
    public void fill(int r, int g, int b, Graphics gr) {
        gr.setColor(new Color(r, g, b));
    }
    
    public void fontSize(int sz, Graphics g) {
        g.setFont(new Font("Avenir", Font.PLAIN, sz));
    }
    
    public void text(String txt, int x, int y, Graphics g) {
        x = transform(x, y)[0];
        y = transform(x, y)[1];
        g.drawString(txt, x, y);
    }
    
    public void line(int x1, int y1, int x2, int y2, Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }
}