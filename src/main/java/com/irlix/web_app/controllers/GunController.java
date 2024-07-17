package com.irlix.web_app.controllers;


import com.irlix.web_app.dao.GunDAO;
import com.irlix.web_app.models.Gun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/guns")
public class GunController {

    private final GunDAO gunDAO;

    @Autowired
    public GunController(GunDAO gunDAO) {
        this.gunDAO = gunDAO;
    }

    @GetMapping()
    public String guns(Model model) {
        model.addAttribute("gunsList", gunDAO.index());
        return "guns/guns";
    }

    @GetMapping("/{id}")
    public String guns(@PathVariable("id") int id, Model model) {
        model.addAttribute("nameGun", gunDAO.show(id));
        return "guns/show";
    }

    @GetMapping("/new")
    public String newGun(Model model) {
        model.addAttribute("addGun", new Gun());
        return "guns/new";
    }

    @PostMapping()
    public String createGun(@ModelAttribute("gun") Gun gun) {
        gunDAO.save(gun);
        return "redirect:/guns";
    }

    @GetMapping("/{id}/edit")
    public String getByType(@PathVariable("id") int id, Model model) {
        model.addAttribute("gun", gunDAO.show(id));
        return "guns/edit";
    }

    @PatchMapping("/{id}")
    public String change(@ModelAttribute("gun") Gun gun, @PathVariable("id") int id) {
        gunDAO.change(id, gun);
        return "redirect:/guns";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        gunDAO.delete(id);
        return "redirect:/guns";
    }
}

