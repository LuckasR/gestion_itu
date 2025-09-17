package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/resultat_entretient")
public class Resultat_entretientController {

    @Autowired
    private Resultat_entretientService service;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CandidatureService candidatureService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("resultat_entretients", service.getAll());
        return "resultat_entretient/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("resultat_entretient", new Resultat_entretient());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("candidatures", candidatureService.getAll());
        return "resultat_entretient/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Resultat_entretient obj) {
        service.save(obj);
        return "redirect:/resultat_entretient";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("resultat_entretient", service.getById(id));
        model.addAttribute("employeeList", employeeService.getAll());
        model.addAttribute("candidatureList", candidatureService.getAll());
        return "resultat_entretient/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Resultat_entretient obj) {
        service.save(obj);
        return "redirect:/resultat_entretient";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/resultat_entretient";
    }}
