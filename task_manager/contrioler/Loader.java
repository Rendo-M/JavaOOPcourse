package task_manager.contrioler;

import java.io.FileReader;

import task_manager.store.Data;

public class Loader {
    String empl;
    String schedule;
    FileReader reader;


    Loader(String empl, String sched){
        this.empl = empl;
        this.schedule = sched;
    }

    public void readEmployees(Data data){
        data.addEmployee("Boev","Alexandr" ,"general constructor");
        data.addEmployee("Dorohov","Andrey" ,"constructor");
        data.addEmployee("Vasilyev","Dmitri" ,"constructor");
        data.addEmployee("Ivanov","Ivan" ,"master");
        data.addEmployee("Filatov","Alexey" ,"mechanic");
        data.addEmployee("Sergeev","Igor" ,"CNC operator");
        data.addEmployee("Fedorov","Victor" ,"CNC operator");
        
    }
    public void readTasks(Data data){
        data.addTask(1, 0, "создать черттежи для изделия x17 передать их на изготовление на участок ЧПУ", 1);
        data.addTask(3, 1, "изготовить опытный образец изделия x17 по чертежам. Чертежи отправлены на эл почту", 1);
        data.addTask(6, 3, "изготовить опытный образец изделия x17", 0);
        
        
    }

    public void saveToFile(){

    }
}
