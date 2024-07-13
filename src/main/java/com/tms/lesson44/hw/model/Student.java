package com.tms.lesson44.hw.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private String emptyFieldMessage = "Field is empty!";

    @NotEmpty(message = "Field is empty!")
    @Size(min = 2, message = "Field value must be at least 2 characters long.")
    private String name;
    @NotEmpty(message = "Field is empty!")
    @Size(min = 2, message = "Field value must be at least 2 characters long.")
    private String surname;
    @NotEmpty(message = "Field is empty!")
    private String group;
    @Min(value = 1, message = "Value is invalid. Min age: 1.")
    private int age;
    private int id;

    public Student() {
    }

    public Student(String name, String surname, String group, int age, int id) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.age = age;
        this.id = id;
    }
}
