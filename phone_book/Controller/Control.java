package phone_book.Controller;

import phone_book.Model.Phonebook;
import phone_book.View.View;

public class Control {
    Phonebook pb;
    View view;
    Control(){
    }

    public void showBook(){
        pb.filtrate();
    }


    public void addFilter(){
        String fname = this.view.ask("введите часть имени для фильтрации >> ");
        String lname = this.view.ask("введите часть фамилии для фильтрации >> ");
        String phone = this.view.ask("введите часть номера для фильтрации >> ");
        this.pb.setFilter(fname, lname, phone);
        this.pb.filtrate();
    }


    public void resetFilter(){
        this.pb.setFilter("", "","");
        this.pb.filtrate();
    }


    public void changePhone(){
        this.pb.filtrate();
        int num = Integer.parseInt(this.view.ask("номер записи для изменения>> "));
        String phone = this.view.ask("новый номер телефона >> ");
        pb.filtered.get(num).setPhone(phone);
    }


    public void deleteRecord(){
        this.pb.filtrate();
        int num = Integer.parseInt(this.view.ask("номер записи для удаления>> "));
        pb.filtered.remove(num);
    }


    public void addRecord(){
        String fname = this.view.ask("введите имя >> ");
        String lname = this.view.ask("введите фамилию >> ");
        String phone = this.view.ask("введите номер телефона >> ");
        this.pb.addRecord(fname, lname, phone);
        this.pb.filtrate();
        
    }

    public void run(){
    }

}
