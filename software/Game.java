import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
import java.util.*;

public class Game {

    private GameWindow window;
    
    private boolean someFlag;
    
    public Game() {
        window = new GameWindow();
    }
    
    private class GameWindow extends DrawingWindow {
        
        GameWindow() {
            super("Very clever title");
        }
        
        public void onRedraw(Graphics g, int w, int h) {
            g.clearRect(0, 0, w, h);
            if (someFlag) {
                g.drawLine(0, 0, w, h);
            } else {
                g.drawLine(0, h, w, 0);
            }
        }
        
        public void onClick(int button, int x, int y) {
            someFlag = !someFlag;
            redraw();
        }
        
    }
    
    public static void main(String... args) {
        new Game();
    }
}


class DrawingWindow {

    private JFrame frame;
    private JPanel panel;

    public DrawingWindow(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel() {
            public void paint(Graphics g) {
                onRedraw(g, getWidth(), getHeight());
            }
        };
        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                onClick(e.getButton(), e.getX(), e.getY());
            }
        });
    }
    
    public void redraw() {
        panel.invalidate();
        panel.repaint();
    }
    
    public void onRedraw(Graphics g, int w, int h) {
        g.drawLine(0, 0, w, h);
    }
    
    public void onClick(int button, int x, int y) {
    }

}

