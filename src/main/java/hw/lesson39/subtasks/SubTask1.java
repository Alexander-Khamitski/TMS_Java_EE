package hw.lesson39.subtasks;

import org.springframework.beans.factory.annotation.Autowired;

public class SubTask1 {

    @Autowired
    private String subTask1Message;

    public void getSubTask1Message() {
        System.out.println(subTask1Message + " was done.");
    }

    public void setSubTask1Message(String subTask1Message) {
        System.out.println("SubTask1 was set as: " + subTask1Message);
        this.subTask1Message = subTask1Message;
    }
}
