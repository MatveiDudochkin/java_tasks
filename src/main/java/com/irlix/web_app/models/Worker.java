package com.irlix.web_app.models;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int experience;
    private String specialization;
    private int managerID;
}
