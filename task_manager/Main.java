package task_manager;

import task_manager.contrioler.Control;

public class Main {
    public static void main(String[] args) {

        Control controller = new Control("empl.txt", "tasks.txt");
        controller.run();
}
    
}
