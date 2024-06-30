package hw.lesson39.subtasks;

import org.springframework.beans.factory.annotation.Autowired;

public class SubTask3 {

    @Autowired
    private String subTask3Message;

    public void getSubTask3Message() {
        System.out.println(subTask3Message + " was done.");
    }

    public void setSubTask3Message(String subTask3Message) {
        System.out.println("SubTask3 was set as: " + subTask3Message);
        this.subTask3Message = subTask3Message;
    }
}
