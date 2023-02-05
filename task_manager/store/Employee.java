package task_manager.store;

public class Employee {
    public String lastName;
    public String firstName;
    String position;

    Employee(String lastName, String firstName, String position){
        this.lastName = lastName;
        this.firstName = firstName;
        this.position = position;
        
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.lastName + ", " + this.position;
    }
}
