package phone_book.Model;

import java.util.ArrayList;

public class Phonebook {
   ArrayList<Record> phonebook;
   public ArrayList<Record> filtered;
   Record filter;


public Phonebook(){
    this.filtered = new ArrayList<>();
    this.phonebook = new ArrayList<>();
    this.setFilter("", "", "");
}   


public Record getFilter() {
    return filter;
}


public void setFilter(String fname, String lname, String phone) {
    this.filter = new Record(fname, lname, phone);   
}  


public void showBook(ArrayList<Record> book){
    int i = 1;
    for (Record record : book) {
        System.out.println(i+" "+record);
        i += 1;
    }
}


public void filtrate(){
    for (int i = 0; i < phonebook.size(); i++) {
        if (phonebook.get(i).isAppropriate(this.filter)){
            this.filtered.add(phonebook.get(i));
        }
    }
    this.showBook(filtered);
}

public void addRecord(String fname, String lName, String phone){
    this.phonebook.add(new Record(fname, lName, phone));
  
}
}
