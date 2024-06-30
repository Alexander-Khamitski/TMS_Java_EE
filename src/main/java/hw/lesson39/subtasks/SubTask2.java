package hw.lesson39.subtasks;

import org.springframework.beans.factory.annotation.Autowired;

public class SubTask2 {

    @Autowired
    private String subTask2Message;

    public void getSubTask2Message() {
        System.out.println(subTask2Message + " was done.");
    }

    public void setSubTask2Message(String subTask2Message) {
        System.out.println("SubTask2 was set as: " + subTask2Message);
        this.subTask2Message = subTask2Message;
    }
}
