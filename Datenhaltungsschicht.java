package Serializable;
import java.io.* ;


public class Datenhaltungsschicht 
{
  
   public void spielSpeichern ()
  {
    
      try {
         FileOutputStream fileOut =
         new FileOutputStream("tabelle.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(p1);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in tabelle.ser");
      } catch (IOException i) {
         i.printStackTrace();
      }
   
 
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
  public static void main (String[]args)
  {
  s3.spielSpeichern();
  }
}

