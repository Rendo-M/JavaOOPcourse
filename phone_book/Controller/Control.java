package phone_book.Controller;


import java.io.IOException;

import phone_book.IO.Loader;
import phone_book.IO.Logger;
import phone_book.Model.Phonebook;
import phone_book.View.View;

public class Control {
    public Phonebook pb;
    View view;
    String menu = "\n************************\n1 Импорт из формата 1 \n2 Импорт из формата 2\n3 Экспорт в формате 1\n4 Экспорт в формат 2\n5 Показать записи\n6 Установить фильтр\n7 Сбросить фильтр\n8 Редактировать\n9 Добавить запись\n0 Удалить запись\n* - Выход\n************************\n";
    Loader loader;
    Logger logger;

    public Control() throws IOException{
        this.pb = new Phonebook();
        this.view = new View();
        this.loader = new Loader();
        this.logger = new Logger();
    }

    public void showBook(){
        this.view.sout("++++++++++++++++++++++");
        pb.filtrate();
        this.view.sout("++++++++++++++++++++++");
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


    public void changePhone() throws IOException{
        this.pb.filtrate();
        int num = Integer.parseInt(this.view.ask("номер записи для изменения>> "));
        logger.add("user change record: " + pb.filtered.get(num-1).toString());
        String phone = this.view.ask("новый номер телефона >> ");
        pb.filtered.get(num-1).setPhone(phone);
        logger.add("to record: " + pb.filtered.get(num-1).toString());
    }


    public void deleteRecord() throws IOException{
        this.pb.filtrate();
        int num = Integer.parseInt(this.view.ask("номер записи для удаления>> "));
        logger.add("user delete record" + pb.filtered.get(num-1).toString());
        pb.delRecord(pb.filtered.get(num-1));
        this.showBook();
    }


    public void addRecord() throws IOException{
        String fname = this.view.ask("введите имя >> ");
        String lname = this.view.ask("введите фамилию >> ");
        String phone = this.view.ask("введите номер телефона >> ");
        this.pb.addRecord(fname, lname, phone);
        logger.add("user add new record: " + fname + " " + lname + " " + phone);
        this.pb.filtrate();
        
    }

    public void run() throws IOException{
        this.logger.add("new session starts");
        while (true){
            this.view.sout(menu);
            String answer = this.view.ask("Выберите действие >>");
            this.logger.add("user calls function " + answer);
            if (answer.equals("*"))
                break;
            int num = Integer.parseInt(answer);
            switch (num){
                case 3: 
                    this.loader.savePhones1(pb);
                    break;
                case 4: 
                    this.loader.savePhones2(pb);
                    break;
                case 1:
                    this.pb = new Phonebook();
                    this.loader.loadPhones1(pb);
                    break;
                case 2: 
                    this.pb = new Phonebook();
                    this.loader.loadPhones2(pb);
                    break;
                case 5: 
                    this.showBook();
                    break;
                case 6: 
                    this.addFilter();;
                    break;
                case 7:
                    this.resetFilter(); 
                    break;
                case 8:
                    this.changePhone(); 
                    break;
                    case 9: 
                        this.addRecord();
                        break;
                    case 0: 
                        this.deleteRecord();
                        break;
            }

        }

    }

}
