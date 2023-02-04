package task_manager.contrioler;
import java.util.ArrayList;

import task_manager.View;
import task_manager.store.Data;
import task_manager.store.Task;

public class Control {
    Integer userID;
    Data schedule;
    View view;

    public Control(String empl, String tasks, Integer userID){
        Loader loader = new Loader(empl, tasks);
        this.schedule = new Data();
        loader.readEmployees(schedule);
        loader.readTasks(schedule);
        this.userID = userID;
        this.view = new View(); 

    }
    
public void showSetted()
{   ArrayList<Task> setted = schedule.getTasksByMaster(this.userID);
    this.view.sout(setted.toString()); 
    }



public void showToDo(){
    ArrayList<Task> todo = schedule.getTasksByPerformer(this.userID);
    this.view.sout(todo.toString());
}

public void showByID(Integer ID){
    this.view.sout(schedule.getTasksByPerformer(ID).toString());
    this.view.sout(schedule.getTasksByMaster(ID).toString());
}
}
