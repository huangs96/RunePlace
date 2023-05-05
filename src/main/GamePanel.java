package main;

import javax.swing.JPanel;
import java.awt.*;
import entity.Player;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16 x 16 tile, default size of 2D character
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48 x 48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread; //automatically calls run method
    Player player = new Player(this, keyH );

    //set char default position

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // renders better performance
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // 0.01666 secs
        double nextDrawTime = System.nanoTime() + drawInterval;

        //as long as game thread exists, repeat method
        while(gameThread != null) {
            //1. UPDATE: update information such as char positions
            update();
            //2. DRAW:: draw the screen with update char positions
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update() {
        player.update();
    }

    //standard method to draw on JPanel
    public void paintComponent(Graphics g) {
        //super means that the parent class of the Paint Component class is the Game Panel class
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        player.draw(g2);
        //Dispose graphic and release any system resources to save memory
        g2.dispose();
    }
}