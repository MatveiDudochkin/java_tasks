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
                result = calculation.getFirstArg() / calculation.getSecondArg();
                break;
            default: result = 0;
        }
        model.addAttribute("result", result);
        return "calc/calculator";
    }

    @GetMapping
    public String calculator(Model model) {
        model.addAttribute("list_operations", calcDAO.getAllOperations());
        return "calc/calculator";
    }
    @PostMapping("/calculator")
    public String createNewOperation(@ModelAttribute("save") Calculate calc) {
        CalcDAO.save(calc);
        return "/calc/calculator";
    }
}
