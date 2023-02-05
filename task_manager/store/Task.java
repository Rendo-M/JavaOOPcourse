package task_manager.store;


import java.time.LocalDate;

public class Task {
    public Employee performer;
    Employee vendor;
    LocalDate date;
    String description;
    String priority;
    int daysToDeadline;

    Task(Employee performer, Employee master, String descr, String priority){
        this.performer = performer;
        this.vendor = master;
        this.description = descr;
        this.priority = priority;
        this.daysToDeadline = 10;
        if (priority.equals("HIGH")) this.daysToDeadline = 1;
        if (priority.equals("MEDIUM")) this.daysToDeadline = 5;
        this.date = LocalDate.now();
        
    }

    public boolean isNeedToClose(){
        return true;
    };     
    
    @Override
    public String toString(){
        
        return "\n********************************\nЗадачу поставил: " + this.vendor + "\nИсполнитель: " + this.performer +"\nПриоритет: "+ this.priority + "\nДата постановки: "+ this.date +"\nДедлайн: "+ this.deadlineDate()+"\n_______________________________\n"+ this.description + "\n********************************";
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

    public String deadlineDate(){
        return date.plusDays(this.daysToDeadline).toString();
    }
}
