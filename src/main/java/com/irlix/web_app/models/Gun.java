package com.irlix.web_app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Gun {
    private int id;
    private String name;
    private String type;
    private int bullets;
}
