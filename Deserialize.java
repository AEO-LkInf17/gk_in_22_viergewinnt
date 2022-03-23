import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Deserialize {
   public static void main(String[]args) {
     vierGewinntt p1 = null;
      try {
         FileInputStream fileIn = new FileInputStream("(tabelle.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         p1 = (vierGewinnt) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return;
      } catch (ClassNotFoundException c) {
         System.out.println("Tabelle class not found");
         c.printStackTrace();
         return;
      }
   }
}
