package task_manager.store;


import java.time.LocalDate;

public class Task {
    Employee performer;
    Employee vendor;
    LocalDate date;
    String description;
    String priority;

    Task(Employee performer, Employee master, String descr, String priority){
        this.performer = performer;
        this.vendor = master;
        this.description = descr;
        this.priority = priority;
        this.date = LocalDate.now();
    }

    public boolean isNeedToClose(){
        return true;
    };     
    
    @Override
    public String toString(){
        return "Задачу поставил: " + this.performer + "\nИсполнитель: " + this.vendor +"\nДата постановки: "+ this.date +"\n"+ this.description;
    }
}
