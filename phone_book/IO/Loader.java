package phone_book.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import phone_book.Model.Phonebook;

public class Loader {
    
    public Loader(){

    }

    public void loadPhones(Phonebook phones){
        phones.addRecord("Max","Mironov","123121");
        phones.addRecord("Andry","Belih","121233");
        phones.addRecord("Alexandr" ,"Boev", "234332");
        phones.addRecord("Andrey" ,"Dorohov", "234223");
        phones.addRecord("Dmitri" ,"Vasilyev", "2341112");
        phones.addRecord("Ivan" ,"Ivanov", "234345");
        phones.addRecord("Alexey" ,"Filatov", "2314122");
        phones.addRecord("Igor" ,"Sergeev", "234564");
        phones.addRecord("Victor" ,"Fedorov", "234666");
    }
    public void savePhones1(Phonebook phones){
        try(FileWriter writer = new FileWriter("phones1.txt", false))
        {
           
            for (phone_book.Model.Record record : phones.getAllRecords()) {
                writer.write(record.firstName+"\n"+record.lastName+"\n"+record.phone+"\n******************\n");
             
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }    
    }
    public void savePhones2(Phonebook phones){
        try(FileWriter writer = new FileWriter("phones2.txt", false))
        {
           
            for (phone_book.Model.Record record : phones.getAllRecords()) {
                writer.write(record.firstName+";"+record.lastName+";"+record.phone+"\n");
             
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }    
    }
    public void loadPhones2(Phonebook phones){
        try(FileReader fr = new FileReader("phones2.txt");
        BufferedReader reader = new BufferedReader(fr);)
        {
            String line;
            while ((line = reader.readLine()) != null) {
                    phones.addRecord(line.split(";", 3)[0],line.split(";", 3)[1], line.split(";", 3)[2]);           }
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }   
    }
    public void loadPhones1(Phonebook phones){
        
        try(FileReader fr = new FileReader("phones1.txt");
        BufferedReader reader = new BufferedReader(fr);)
        {
            String fName, lName, phone;

            while ((fName = reader.readLine()) != null) {
                lName = reader.readLine();
                phone = reader.readLine();
                reader.readLine();
                phones.addRecord(fName, lName, phone);           }
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }   
    }
}
