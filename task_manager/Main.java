package task_manager;

import task_manager.contrioler.Control;

public class Main {
    public static void main(String[] args) {

        Control controller = new Control("empl.txt", "tasks.txt", -1);
        controller.showEmployees();
        int id = Integer.parseInt(controller.view.ask("Для входа в систему введите ваш идентификатор: "));
        controller.setUserID(id);
        controller.view.sout("здравствуйте "+controller.getEmployee(id).firstName);
}
    
}
