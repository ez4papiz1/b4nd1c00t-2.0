package crashBANDICOOT;

import java.awt.Image;
import java.awt.Toolkit;

public class projectile {
   private float xCoord = 0.0F;
   private int yCoord = 0;
   private int width = 120;
   private int height = 60;
   private Image img;

   public projectile() {
      this.setxCoord(10.0F);
      this.setyCoord(10);
      this.setWidth(30);
      this.setHeight(30);
      this.setImg("../files/Boomerang.png");
   }

   public projectile(int x, int y, int w, int h, String imgpath) {
      this.setxCoord((float)x);
      this.setyCoord(y);
      this.setWidth(w);
      this.setHeight(h);
      this.setImg(imgpath);
   }

   public void setImg(String imgpath) {
      this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
   }

   public float getxCoord() {
      return this.xCoord;
   }

   public void setxCoord(float xCoord) {
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
