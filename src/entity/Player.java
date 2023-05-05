package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class Player extends Entity {
     GamePanel gp;
     KeyHandler keyH;

     public Player(GamePanel gp, KeyHandler keyH) {
          this.gp = gp;
          this.keyH = keyH;

          setDefaultValues();
          getPlayerImg();
     }

     public void setDefaultValues() {
          x = 100;
          y = 100;
          speed = 4;
          direction = "up";
     }

     public void getPlayerImg() {
          try {
               up1 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charUp1.png")));
               up2 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charUp2.png")));
               up3 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charUp3.png")));
               down1 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charDown1.png")));
               down2 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charDown2.png")));
               down3 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charDown3.png")));
               right1 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charRight1.png")));
               right2 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charRight2.png")));
               right3 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charRight3.png")));
               left1 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charLeft1.png")));
               left2 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charLeft2.png")));
               left3 = ImageIO.read((getClass().getResourceAsStream("/charImgs/charLeft3.png")));
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
          BufferedImage image = null;

          switch(direction) {
               case "up":
                    image = up1;
                    break;
               case "down":
                    image = down1;
                    break;
               case "right":
                    image = right1;
                    break;
               case "left":
                    image = left1;
                    break;
          }

          g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
     }
}
