package com.irlix.web_app.dao;

import com.irlix.web_app.models.Calculate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CalcDAO {
    private List<String> operations = new ArrayList<>();

    public void addOperation(Calculate calc) {
        switch (calc.getOperation()) {
            case "+":
                calc.setResult(calc.getResult() + calc.getResult());
                break;
            case "-":
                calc.setResult(calc.getResult() - calc.getResult());
                break;
            case "*":
                calc.setResult(calc.getResult() * calc.getResult());
                break;
            case "/":
                calc.setResult(calc.getResult() / calc.getResult());
                break;
            default:
                calc.setResult(0);
        }
        operations.add(calc.toString());
    }
}
