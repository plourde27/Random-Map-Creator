import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.Math.*;

public class Display extends JComponent{
    Game game;
    Mouse mouse;
    Keyboard kb;
    Color[][] prec;
    int tx = 0;
    int ty = 0;
    int ang = 0;
    final int FAC = 3;
    Scanner scn;
    
    
    public Display(Game g, Mouse m, Keyboard k) {
        game = g;
        mouse = m;
        kb = k;
        scn = new Scanner(System.in);
        prec = new Color[6][60];
        for (int i = 0 ; i < 6 ; i++) {
            for (int j = 0 ; j < 60 ; j++) {
                prec[i][j] = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            }
        }
    }
    
    
    
    public void draw(){
        super.repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
    }
}