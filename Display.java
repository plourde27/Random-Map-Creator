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
    
    public Display(Game g, Mouse m, MouseWheel mmw, Keyboard k) {
        game = g;
        mouse = m;
        mw = mmw;
        kb = k;
        map = new Map();
    }
    
    public void draw(){
        super.repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        map.drawMap(g, mouse, mw, kb);
    }
}