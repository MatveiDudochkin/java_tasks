package com.irlix.web_app.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculate {
    private int id;
    private double firstArg;
    private double secondArg;
    private String operation;
    private double result;

    @Override
    public String toString() {
        return firstArg + " " + operation + " " + secondArg + " = " + result;
    }
}
