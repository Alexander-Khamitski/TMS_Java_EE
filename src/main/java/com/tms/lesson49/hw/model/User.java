package com.tms.lesson49.hw.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String passportNumber;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", passport_number='" + passportNumber + '\'' +
                '}';
    }
}
