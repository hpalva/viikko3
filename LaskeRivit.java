import java.util.Scanner;
public class LaskeRivit {
  private static Scanner lukija = new Scanner(System.in);
   public static void main(String[] args) {

     int lkm = 0;
     while (lukija.hasNextLine()) {
       lukija.nextLine();
       lkm = lkm + 1;
     }
     System.out.println(lkm);
   }
}
