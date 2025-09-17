package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("statuss", service.getAll());
        return "status/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("status", new Status());
        return "status/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Status obj) {
        service.save(obj);
        return "redirect:/status";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("status", service.getById(id));
        return "status/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Status obj) {
        service.save(obj);
        return "redirect:/status";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/status";
    }}
