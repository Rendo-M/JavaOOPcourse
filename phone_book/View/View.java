package phone_book.View;

import java.util.Scanner;

public class View {
    Scanner in;
    public View(){
        in = new Scanner(System.in);
    }
   public void sout(String text) {
    System.out.println(text);
   } 
   public String ask(String text) {
    System.out.println(text);
    return in.nextLine();
   }
}
