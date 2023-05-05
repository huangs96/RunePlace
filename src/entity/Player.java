package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class Player extends Entity {
     GamePanel gp;
     KeyHandler keyH;

     public Player(GamePanel gp, KeyHandler keyH) {
          this.gp = gp;
          this.keyH = keyH;

          setDefaultValues();
     }

     public void setDefaultValues() {
          x = 100;
          y = 100;
          speed = 4;
          direction = "down";
     }

     public void getPlayerImg() {
          try {
               up1 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charUp1.png"));
               up2 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charUp2.png"));
               up3 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charUp3.png"));
               down1 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charDown1.png"));
               down2 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charDown2.png"));
               down3 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charDown3.png"));
               right1 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charRight1.png"));
               right2 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charRight2.png"));
               right3 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charRight3.png"));
               left1 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charLeft1.png"));
               left2 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charLeft2.png"));
               left3 = ImageIO.read(getClass().getResourceAsStream("src/charImg/charLeft3.png"));
          } catch(IOException e) {
               e.printStackTrace();
          }
     }

     public void update() {
          if(keyH.upPressed) {
               direction = "up";
               y -= speed; // same as 'playerY = playerY - playerSpeed'
          }
          else if (keyH.downPressed) {
               direction = "down";
               y += speed;
          }
          else if (keyH.leftPressed) {
               direction = "left";
               x -= speed;
          }
          else if (keyH.rightPressed) {
               direction = "right";
               x += speed;
          }
     }

     public void draw (Graphics2D g2) {
          g2.setColor(Color.white);
          g2.fillRect(x, y, gp.tileSize, gp.tileSize);
     }
}
