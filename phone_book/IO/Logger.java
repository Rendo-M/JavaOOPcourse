package phone_book.IO;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    String log = "log.txt";
    FileWriter writer; 
    public Logger() throws IOException{
       this.writer = new FileWriter(this.log, true);
        
           
            
        }
    public void add(String msg) throws IOException{
        writer.write(msg);
        writer.append('\n');
        writer.flush();
    }   

    }

