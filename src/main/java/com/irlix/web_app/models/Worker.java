package com.irlix.web_app.models;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Worker {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String experience;
    private String specialization;
    private int managerID;

    public Worker() {
    }

    public Worker(int id, String name, String surname, int age, String experience, String specialization, int managerID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = experience;
        this.specialization = specialization;
        this.managerID = managerID;
    }
}
