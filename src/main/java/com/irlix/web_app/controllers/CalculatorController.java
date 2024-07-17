package com.irlix.web_app.controllers;

import com.irlix.web_app.models.Calculate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/calc")
public class CalculatorController {
    List<Calculate> calcList = new ArrayList<>();

    @GetMapping("/calculator")
    public String showCalc(Model model) {
        model.addAttribute("calculation", new Calculate());
        model.addAttribute("calcList", calcList);
        return "calc/calculator";
    }

    @PostMapping("/calculator")
    public String processCalc(@ModelAttribute("calculation") Calculate calculation, Model model) {
        double result;
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
        calcList.add(calculation);
        model.addAttribute("result", result);
        model.addAttribute("calcList", calcList);
        return "calc/calculator";
    }
}
