import java.util.*;
import javax.swing.*;

public class Main 
{
  public static void main(String[] args) 
    {
        
        JFrame frame = new JFrame("DISPLAY");
        Game game = new Game();
        
        
        Mouse mouse = new Mouse();
        frame.addMouseListener(mouse);
        MoveMouse movemouse = new MoveMouse();
        frame.addMouseMotionListener(movemouse);
        Keyboard keyboard = new Keyboard();
        frame.addKeyListener(keyboard);
        MouseWheel mmw = new MouseWheel();
        frame.addMouseWheelListener(mmw);
        Display screen = new Display(game, mouse, movemouse, mmw, keyboard);
        frame.add(screen);
        
        frame.setBounds(0,0,1080,720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Thread(game).start();
        new Thread(new frameRateUpdater(30,screen)).start();
  }
}