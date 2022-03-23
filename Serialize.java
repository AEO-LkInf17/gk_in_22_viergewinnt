package Serializable
import java.io.File;
import java.io.FileOutputstream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Serialize {

   public static void main(String[]args) {
      try {
         FileOutputStream fileOut =
         new FileOutputStream("/tmp/tabelle.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(t);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in /tmp/tabelle.ser");
      } catch (IOException i) {
         i.printStackTrace();
      }
   }
}
