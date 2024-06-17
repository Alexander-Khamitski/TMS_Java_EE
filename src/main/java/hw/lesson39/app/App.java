package hw.lesson39.app;

import hw.lesson39.config.AppConfig;
import hw.lesson39.tasks.Task1;
import hw.lesson39.tasks.Task2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Task1 task1 = (Task1) context.getBean("task1");
        Task2 task2 = (Task2) context.getBean("task2");

        task1.getSubTask1Class().getSubTask1Message();
        task1.getSubTask2Class().getSubTask2Message();
        task1.getSubTask3Class().getSubTask3Message();
        task1.getTask1();
        task2.getTask2();
    }
}
