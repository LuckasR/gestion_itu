package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/planing_entretient")
public class Planing_entretientController {

    @Autowired
    private Planing_entretientService service;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CandidatureService candidatureService;

    @Autowired
    private Siege_entrepriseService siege_entrepriseService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("planing_entretients", service.getAll());
        return "planing_entretient/index";
    }

    @GetMapping("/create/{idCandidature}")
    public String createForm(@PathVariable("idCandidature") Integer idCandidature, Model model) {
        Planing_entretient planing = new Planing_entretient();
        Candidature candidature = candidatureService.getById(idCandidature);
         if (candidature == null) {
            // Gérer le cas où la candidature n'existe pas
            return "redirect:/planing_entretient"; // ou une autre page d'erreur
        }
        planing.setCandidature(candidature); // liaison candidature → entretien

        model.addAttribute("planing_entretient", planing);
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("candidature", candidatureService.getById(idCandidature)); 
        model.addAttribute("siege_entreprises", siege_entrepriseService.getAll());

        return "planing_entretient/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Planing_entretient obj) {
        service.save(obj);
        return "redirect:/planing_entretient";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("planing_entretient", service.getById(id));
        model.addAttribute("employeeList", employeeService.getAll());
        model.addAttribute("candidatureList", candidatureService.getAll());
        model.addAttribute("siege_entrepriseList", siege_entrepriseService.getAll());
        return "planing_entretient/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Planing_entretient obj) {
        service.save(obj);
        return "redirect:/planing_entretient";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/planing_entretient";
    }}
