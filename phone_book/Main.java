package phone_book;

import phone_book.Controller.Control;
import phone_book.IO.Loader;

public class Main {
    public static void main(String[] args) {
       
       Control ct = new Control(); 
       Loader loader = new Loader() ;
       loader.loadPhones2(ct.pb);
       ct.showBook();
       
    }
}
