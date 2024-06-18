package hw.lesson39.config;

import hw.lesson39.subtasks.SubTask1;
import hw.lesson39.subtasks.SubTask2;
import hw.lesson39.subtasks.SubTask3;
import hw.lesson39.tasks.Task1;
import hw.lesson39.tasks.Task2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public Task1 task1() {
        return new Task1();
    }

    @Bean("task1Message")
    public String getTask1Message() {
        return "Task1 was set as: 'Some task #1'";
    }

    @Bean
    @Scope("singleton")
    public Task2 task2() {
        return new Task2();
    }

    @Bean("task2Message")
    public String getTask2Message() {
        return "Task2 was set as: 'Some task #2'";
    }

    @Bean
    public SubTask1 subTask1() {
        return new SubTask1();
    }

    @Bean("subTask1Message")
    public String getSubTask1Message() {
        return "SubTask1 was set as: 'Some sub task #1'";
    }

    @Bean
    public SubTask2 subTask2() {
        return new SubTask2();
    }

    @Bean("subTask2Message")
    public String getSubTask2Message() {
        return "SubTask2 was set as: 'Some sub task #2'";
    }

    @Bean
    public SubTask3 subTask3() {
        return new SubTask3();
    }

    @Bean("subTask3Message")
    public String getSubTask3Message() {
        return "SubTask3 was set as: 'Some sub task #3'";
    }
}
