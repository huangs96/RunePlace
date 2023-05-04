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

    Thread gameThread; //automatically calls run method

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // renders better performance
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //game loop

        //as long as game thread exists, repeat method
        while(gameThread != null) {
            //1. UPDATE: update information such as char positions
            update();
            //2. DRAW:: draw the screen with update char positions
            repaint();
        }
    }

    public void update() {

    }

    //standard method to draw on JPanel
    public void paintComponent(Graphics g) {
        //super means that the parent class of the Paint Component class is the Game Panel class
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(100, 100, tileSize, tileSize);
        //Dispose graphic and release any system resources to save memory
        g2.dispose();
    }
}
