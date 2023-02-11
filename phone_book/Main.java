package phone_book;

import java.io.IOException;

import phone_book.Controller.Control;
import phone_book.IO.Loader;

public class Main {
    public static void main(String[] args) throws IOException {
       
       Control ct = new Control(); 
       ct.run();
       
    }
}
