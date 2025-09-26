package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/jour_ferie")
public class Jour_ferieController {

    @Autowired
    private Jour_ferieService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("jour_feries", service.getAll());
        return "jour_ferie/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("jour_ferie", new Jour_ferie());
        return "jour_ferie/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Jour_ferie obj) {
        service.save(obj);
        return "redirect:/jour_ferie";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("jour_ferie", service.getById(id));
        return "jour_ferie/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Jour_ferie obj) {
        service.save(obj);
        return "redirect:/jour_ferie";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/jour_ferie";
    }}
