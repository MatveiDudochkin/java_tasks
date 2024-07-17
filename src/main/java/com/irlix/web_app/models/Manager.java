package com.irlix.web_app.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int experience;
    private List<Worker> workers = new ArrayList<>();
}
