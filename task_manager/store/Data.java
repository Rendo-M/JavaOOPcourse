package task_manager.store;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    ArrayList <Employee> crew;
    public ArrayList <Task> planner;
    HashMap<Integer, String> prior;

    public Data(){
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

    public Employee getEmployee(Integer ID){
        return this.crew.get(ID);
    }

    public ArrayList<Task> getTasksByMaster(Integer MasterID){
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : this.planner) 
            if (task.getMaster().equals(getEmployee(MasterID)))
                result.add(task);                    
        return result;
    }
    public ArrayList<Task> getTasksByPerformer(Integer MasterID){
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : this.planner) 
            if (task.getPerformer().equals(getEmployee(MasterID)))
                result.add(task);                    
        return result;
    }
}
