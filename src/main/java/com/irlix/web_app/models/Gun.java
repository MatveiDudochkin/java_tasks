package com.irlix.web_app.models;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Gun {
    private int id;
    private String name;
    private String type;
    private int bullets;

    public Gun() {}

    public Gun(int id, String name, String type, int bullets) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.bullets = bullets;
    }
}
