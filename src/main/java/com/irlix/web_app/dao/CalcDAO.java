package com.irlix.web_app.dao;

import com.irlix.web_app.models.Calculate;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CalcDAO {
    private static int OPERATION_COUNT;
    private final List<Calculate> operations;

    {
        operations = new ArrayList<>();
        operations.add(new Calculate(++OPERATION_COUNT, 1.1, 2.2, "+", 3.3 ));
    }

    public void save(Calculate calculate) {
        calculate.setId(++OPERATION_COUNT);
        operations.add(calculate);
    }
    public List<Calculate> getAllOperations() {
        return operations;
    }
}
