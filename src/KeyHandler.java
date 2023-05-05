import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("clicked");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //returns number of key that was pressed
        int code = e.getKeyCode();
        //user pressing key
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            System.out.println("clicked");
            leftPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            System.out.println("clicked");
            downPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            System.out.println("clicked");
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            System.out.println("clicked");
            upPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
