package hw.lesson39.tasks;

import hw.lesson39.subtasks.SubTask1;
import hw.lesson39.subtasks.SubTask2;
import hw.lesson39.subtasks.SubTask3;
import org.springframework.beans.factory.annotation.Autowired;

public class Task1 {

    @Autowired
    private String task1Message;

    @Autowired
    private SubTask1 subTask1;

    @Autowired
    private SubTask2 subTask2;

    @Autowired
    private SubTask3 subTask3;

    public void getTask1() {
        System.out.println(task1Message + " was done.");
    }

    public void setTask1(String task1Message) {
        System.out.println("Task1 was set as: " + task1Message);
        this.task1Message = task1Message;
    }

    public SubTask1 getSubTask1Class() {
        return subTask1;
    }

    public void setSubTask1(SubTask1 subTask1) {
        this.subTask1 = subTask1;
    }

    public SubTask2 getSubTask2Class() {
        return subTask2;
    }

    public void setSubTask2(SubTask2 subTask2) {
        this.subTask2 = subTask2;
    }

    public SubTask3 getSubTask3Class() {
        return subTask3;
    }

    public void setSubTask3(SubTask3 subTask3) {
        this.subTask3 = subTask3;
    }
}
