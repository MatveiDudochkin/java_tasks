package com.irlix.web_app.controllers;

import com.irlix.web_app.dao.CalcDAO;
import com.irlix.web_app.models.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/calc")
public class CalculatorController {
    private final CalcDAO calcDAO;

    public CalculatorController(CalcDAO calcDAO) {
        this.calcDAO = calcDAO;
    }


    @GetMapping("/calculator")
    public String showCalc(Model model) {
        model.addAttribute("calculation", new Calculate());
        return "calc/calculator";
    }

    @PostMapping("/calculator")
    public String processCalc(@ModelAttribute("calculation") Calculate calculation, Model model) {
        double result = 0;
        switch (calculation.getOperation()) {
            case "+":
                result = calculation.getFirstArg() + calculation.getSecondArg();
                break;
            case "-":
                result = calculation.getFirstArg() - calculation.getSecondArg();
                break;
            case "*":
                result = calculation.getFirstArg() * calculation.getSecondArg();
                break;
            case "/":
                if (calculation.getSecondArg() != 0) {
                    result = calculation.getFirstArg() / calculation.getSecondArg();
                } else {
                    model.addAttribute("error", "Division by zero is not allowed.");
                    return "calc/calculator";
                }
                break;
            default:
                model.addAttribute("error", "Invalid operation.");
                return "calc/calculator";
        }
        model.addAttribute("result", result);
        calculation.setResult(result);
        calcDAO.save(calculation);
        return "calc/calculator";
    }

    /*
    TODO*
    разобраться почему не отображается история
     */
    @GetMapping
    public String showHistory(Model model) {
        model.addAttribute("operations_list", calcDAO.getAllOperations());
        return "calc/calculator";
    }
}
