package com.irlix.web_app.models;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Calculate {
    private int id;
    private double firstArg;
    private double secondArg;
    private String  operation;
    private double  result;

    public Calculate(int id ,double firstArg, double secondArg, String operation, double result) {
        this.id = id;
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.operation = operation;
        this.result = result;
    }
    public Calculate() {}
}
