package com.irlix.web_app.controllers;

import com.irlix.web_app.dao.OfficeDAO;
import com.irlix.web_app.models.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/office")
public class OfficeController {
    private final OfficeDAO officeDAO;

    @Autowired
    public OfficeController(OfficeDAO officeDAO) {
        this.officeDAO = officeDAO;
    }

    @GetMapping()
    public String show(Model model) {
        model.addAttribute("managerList", officeDAO.showManagerList());
        model.addAttribute("workerList", officeDAO.showWorkerList());
        return "office/office";
    }

    @GetMapping("/{id}")
    public String showSoloPageManager(@PathVariable("id") int id, Model model) {
        model.addAttribute("showManager", officeDAO.showManagerPage(id));
        return "/office/showManager";
    }

    @GetMapping("/newManager")
    public String newManager(Model model) {
        model.addAttribute("addManager", new Manager());
        return "office/newManager";
    }

    @PostMapping()
    public String createManager(@ModelAttribute("newManager") Manager manager) {
        officeDAO.createManager(manager);
        return "redirect:/office";
    }
}
