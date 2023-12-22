package crashBANDICOOT;

import java.awt.Color;
import javax.swing.JFrame;

public class MyScreen extends JFrame {
   public MyScreen() {
      this.setSize(800, 600);
      this.setDefaultCloseOperation(3);
      this.setVisible(true);
      this.setBackground(Color.WHITE);
   }

   public static void main(String[] args) {
      MyScreen screen = new MyScreen();
      MyCanvas canvas = new MyCanvas();
      screen.getContentPane().add(canvas);
   }
}
