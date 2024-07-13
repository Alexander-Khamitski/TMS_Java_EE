package com.tms.lesson44.hw.repository;

import java.util.HashMap;
import java.util.Map;

import com.tms.lesson44.hw.model.Student;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class StudentsRepository {

    @Getter
    private Map<Integer, Student> repository;
    private int COUNTER = 0;

    private StudentsRepository() {
        this.repository = new HashMap<>();
        this.repository.put(++COUNTER, new Student("Ivan", "Ivanov", "C27-onl", 25, COUNTER));
        this.repository.put(++COUNTER, new Student("Roman", "Romanov", "C27-onl", 26, COUNTER));
        this.repository.put(++COUNTER, new Student("Alexander", "Alexandrov", "C27-onl", 27, COUNTER));
        this.repository.put(++COUNTER, new Student("Petr", "Petrov", "C27-onl", 28, COUNTER));
        this.repository.put(++COUNTER, new Student("Artem", "Artemov", "C27-onl", 29, COUNTER));
    }

    public void addStudent(Student student) {
        student.setId(++COUNTER);
        this.repository.put(COUNTER, student);
    }
}
