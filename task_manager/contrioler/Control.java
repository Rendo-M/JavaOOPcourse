package task_manager.contrioler;
import java.util.ArrayList;

import task_manager.View;
import task_manager.store.Data;
import task_manager.store.Employee;
import task_manager.store.Task;

public class Control {
    Integer userID;
    Data schedule;
    public View view;
    static String menu = "1 - Показать мои задачи\n2 - Показать поставленные задачи\n3 - Добавить задачу\n4 - Закрыть задачу\n5 - Выход"; 
    public Control(String empl, String tasks){
        Loader loader = new Loader(empl, tasks);
        this.schedule = new Data();
        loader.readEmployees(schedule);
        loader.readTasks(schedule);
        this.view = new View(); 
        this.showEmployees();
        int id = Integer.parseInt(view.ask("Для входа в систему введите ваш идентификатор >> "));
        this.setUserID(id);
        this.view.sout("здравствуйте "+getEmployee(id).firstName);
    }

    public Employee getEmployee(int id){
        return schedule.crew.get(id);
    }
    public void showEmployees(){
        for (int i = 0; i < schedule.crew.size(); i++) {
            view.sout("ID:"+i+" "+schedule.crew.get(i).toString());
        }
    }


    public void setUserID(int n){
        this.userID = n;
    }
public void showSetted()
    {   ArrayList<Task> setted = schedule.getTasksByMaster(this.userID);
        view.sout("Вы поставили задачи: ");
        this.showTasks(setted);
    }


    public void closeTask(){
        this.showSetted();
        int num = Integer.parseInt(view.ask("введите номер задачи для удаления >> "));        
        Task task = schedule.getTasksByMaster(this.userID).get(num);
        if (task.getMaster().equals(schedule.getEmployee(userID))){
            schedule.removeTask(task);
            view.sout("Task closed and removed from planner");
        }
    }
    void addTask(){
        this.showEmployees();
        int perf = Integer.parseInt(view.ask("Введите ID исполнителя >>"));
        int prior = Integer.parseInt(view.ask("Введите приоритет" + schedule.prior+" >>"));
        String desc = view.ask("Описание задачи >>");
        if (perf != this.userID){
        schedule.addTask(perf, this.userID, desc, prior);
        view.sout("Задача добавлена");    
    }
    }

    void showTasks(ArrayList<Task> tasks){
        for (int i = 0; i < tasks.size(); i++) {
            view.sout(i+"."+ tasks.get(i));
        }
    } 

    public void showToDo(){
        ArrayList<Task> todo = schedule.getTasksByPerformer(this.userID);
        view.sout("Вам поставлены задачи: ");
        showTasks(todo);
    }

    public void showByID(Integer ID){
        this.view.sout(schedule.getTasksByPerformer(ID).toString());
        this.view.sout(schedule.getTasksByMaster(ID).toString());
    }
    int showMenu(){
        this.view.sout("\n"+Control.menu);
        return Integer.parseInt(this.view.ask("Ваш выбор >> "));
    }

    public void run(){
        while (true){
            int answer = this.showMenu();
            if (answer == 5) break;
            if (answer == 1) this.showToDo();
            if (answer == 2) this.showSetted();
            if (answer == 3) this.addTask();
            if (answer == 4) this.closeTask();
        }
    }
}
