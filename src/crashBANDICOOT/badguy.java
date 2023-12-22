package crashBANDICOOT;


import java.awt.Image;
import java.awt.Toolkit;

public class badguy {
   private int xCoord = 0;
   private int yCoord = 0;
   private int width = 120;
   private int height = 60;
   private Image img;

   public badguy() {
      this.setxCoord(10);
      this.setyCoord(10);
      this.setWidth(30);
      this.setHeight(30);
      this.setImg("../files/badguyright.png");
   }

   public badguy(int x, int y, int w, int h, String imgpath) {
      this.setxCoord(x);
      this.setyCoord(y);
      this.setWidth(w);
      this.setHeight(h);
      this.setImg(imgpath);
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
}

