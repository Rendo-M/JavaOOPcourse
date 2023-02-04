package task_manager.store;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    ArrayList <Employee> crew;
    ArrayList <Task> planner;
    HashMap<Integer, String> prior;

    Data(){
        this.crew =  new ArrayList<>();
        this.planner = new ArrayList<>();
        prior = new HashMap<>();
        prior.put(0, "HIGH");
        prior.put(1, "MEDIUM");
        prior.put(2, "LOW");
    }
    public void addEmployee(String lastName, String firstName, String position){
        crew.add(new Employee(lastName, firstName, position));     
    }
    public void addTask(int performer, int master, String description, int priority){
        planner.add( new Task(this.crew.get(performer), crew.get(master), description, prior.get(priority)));  
    }
}
