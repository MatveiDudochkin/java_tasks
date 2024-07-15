package com.irlix.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("first/home")
    public String home(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            model.addAttribute("name", "Hello, " + name + " you're home!");
        } else {
            model.addAttribute("name", "Hello, you're home!");
        }
        return "first/home";
    }
}
