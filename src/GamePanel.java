import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16 x 16 tile, default size of 2D character
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48 x 48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    KeyHandler keyH = new KeyHandler();
    Thread gameThread; //automatically calls run method

    //set char default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

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

        double drawInterval = 1000000000/60; // 0.01666 secs
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
        if(keyH.upPressed) {
            playerY -= playerSpeed; // same as 'playerY = playerY - playerSpeed'
        }
        else if (keyH.downPressed) {
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed) {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed) {
            playerX += playerSpeed;
        }
    }

    //standard method to draw on JPanel
    public void paintComponent(Graphics g) {
        //super means that the parent class of the Paint Component class is the Game Panel class
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        //Dispose graphic and release any system resources to save memory
        g2.dispose();
    }
}
