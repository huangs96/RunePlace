package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player extends Entity {
     GamePanel gp;
     KeyHandler keyH;
     boolean animation = false;

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
          direction = "down";
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
               animation = true;
          }
          else if (keyH.downPressed) {
               direction = "down";
               y += speed;
               animation = true;
          }
          else if (keyH.leftPressed) {
               direction = "left";
               x -= speed;
               animation = true;
          }
          else if (keyH.rightPressed) {
               direction = "right";
               x += speed;
               animation = true;
          }

          System.out.println("spriteNum1 = " + spriteNum);
          //counter for char animation
          spriteCounter++;
          if(spriteCounter > 20 && animation) {
               if(spriteNum == 2) {
                    spriteNum = 3;
               }
               else if(spriteNum == 3) {
                    spriteNum = 2;
               }
          spriteCounter = 0;
          }
          System.out.println("spriteNum2 = " + spriteNum);
     }

     public void draw (Graphics2D g2) {
          BufferedImage image = null;

          switch(direction) {
               case "up":
                    if(spriteNum == 1) {
                         image = up1;
                    }
                    if(spriteNum == 2) {
                         image = up2;
                    }
                    if(spriteNum == 3) {
                         image = up3;
                    }
                    break;
               case "down":
                    if(spriteNum == 1) {
                         image = down1;
                    }
                    if(spriteNum == 2) {
                         image = down2;
                    }
                    if(spriteNum == 3) {
                         image = down3;
                    }
                    break;
               case "right":
                    if(spriteNum == 1) {
                         image = right1;
                    }
                    if(spriteNum == 2) {
                         image = right2;
                    }
                    if(spriteNum == 3) {
                         image = right3;
                    }
                    break;
               case "left":
                    if(spriteNum == 1) {
                         image = left1;
                    }
                    if(spriteNum == 2) {
                         image = left2;
                    }
                    if(spriteNum == 3) {
                         image = left3;
                    }
                    break;
          }

          g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
     }
}
