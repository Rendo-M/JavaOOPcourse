package task_manager.store;


import java.time.LocalDate;

public class Task {
    public Employee performer;
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
        return "\n********************************\nЗадачу поставил: " + this.vendor + "\nИсполнитель: " + this.performer +"\nДата постановки: "+ this.date +"\n_______________________________\n"+ this.description + "\n********************************";
    }
    public Employee getMaster(){
        return this.vendor;
    }
    public Employee getPerformer(){
        return this.performer;
    }
    public String getPriority(){
        return this.priority;
    }
}
