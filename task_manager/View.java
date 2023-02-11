package task_manager;

import java.io.InputStream;
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
    System.out.print(text);
    return in.nextLine();
   }
}
