package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/emploi_dt_entretient")
public class Emploi_dt_entretientController {

    @Autowired
    private Emploi_dt_entretientService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("emploi_dt_entretients", service.getAll());
        return "emploi_dt_entretient/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("emploi_dt_entretient", new Emploi_dt_entretient());
        return "emploi_dt_entretient/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Emploi_dt_entretient obj) {
        service.save(obj);
        return "redirect:/emploi_dt_entretient";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("emploi_dt_entretient", service.getById(id));
        return "emploi_dt_entretient/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Emploi_dt_entretient obj) {
        service.save(obj);
        return "redirect:/emploi_dt_entretient";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/emploi_dt_entretient";
    }}
