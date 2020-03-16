import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.Math.*;

public class Display extends drawInterface {
    
    Game game;
    Mouse mouse;
    MouseWheel mw;
    Keyboard kb;
    Map map;
    MoveMouse movemouse;
    
    int[] coords;
    
    public Display(Game g, Mouse m, MoveMouse mm, MouseWheel mmw, Keyboard k) {
        super();
        game = g;
        mouse = m;
        mw = mmw;
        kb = k;
        map = new Map();
        movemouse = mm;
        
    }
    
    public void draw(){
        super.repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        map.drawMap(g, mouse, movemouse, mw, kb);
    }
}