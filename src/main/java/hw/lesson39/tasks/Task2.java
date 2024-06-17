package hw.lesson39.tasks;

import org.springframework.beans.factory.annotation.Autowired;

public class Task2 {

    @Autowired
    private String task2Message;

    public void getTask2() {
        System.out.println(task2Message);
    }

    public void setTask2Message(String task2Message) {
        System.out.println("Task2 was set as: " + task2Message);
        this.task2Message = task2Message;
    }
}
