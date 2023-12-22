package crashBANDICOOT;

import java.awt.Image;
import java.awt.Toolkit;

public class goodguy {
   private int xCoord = 0;
   private int yCoord = 0;
   private int width = 60;
   private int height = 60;
   private Image img;
   String imgname = "files/bandicoot.jpg";

   public goodguy() {
      this.setxCoord(10);
      this.setyCoord(10);
      this.setWidth(30);
      this.setHeight(30);
      this.setImg("../files/bandicoot.jpg");
   }

   public goodguy(int x, int y, int w, int h, String imgpath) {
      this.setxCoord(x);
      this.setyCoord(y);
      this.setWidth(w);
      this.setHeight(h);
      this.setImg(imgpath);
      this.imgname = imgpath;
   }

   public void moveIt(int direction, int w, int h) {
      int speed = 20;
      int x = this.getxCoord();
      int y = this.getyCoord();
      if (direction == 39) {
         x += speed;
         if (x > w) {
            x -= speed * 3;
         }

         this.setxCoord(x);
         this.setImg("files/bandicoot.jpg");
         this.imgname = "files/bandicoot.jpg";
      } else if (direction == 37) {
         if (x < 0) {
            x += speed * 3;
         }

         x -= speed;
         this.setxCoord(x);
         this.setImg("files/bandicootleft.jpg");
         this.imgname = "files/bandicootleft.jpg";
      } else if (direction == 40) {
         if (y > h - 10) {
            y -= speed * 3;
         }

         y += speed;
         this.setyCoord(y);
         this.setImg("files/bandicoot.jpg");
      } else if (direction == 38) {
         if (y < 0) {
            y += speed * 3;
         }

         y -= speed;
         this.setyCoord(y);
         this.setImg("files/bandicootleft.jpg");
      }

   }

   public void setImg(String imgpath) {
      this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
   }

   public int getxCoord() {
      return this.xCoord;
   }

   public void setxCoord(int xCoord) {
      this.xCoord = xCoord;
   }

   public int getyCoord() {
      return this.yCoord;
   }

   public void setyCoord(int yCoord) {
      this.yCoord = yCoord;
   }

   public int getWidth() {
      return this.width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   public int getHeight() {
      return this.height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   public Image getImg() {
      return this.img;
   }

   public void setImg(Image img) {
      this.img = img;
   }
}
