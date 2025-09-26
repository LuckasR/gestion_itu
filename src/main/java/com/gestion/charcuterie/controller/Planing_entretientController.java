package com.gestion.charcuterie.controller;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.service.*;

import java.time.LocalDate;
import java.util.List;

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

    @Autowired
    private SocieteService societeService;


    @Autowired
    private Emploi_dt_entretientService serv1 ; 

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

    
    @GetMapping("/createAuto/{idCandidature}")
    public String createAuto(@PathVariable("idCandidature") Integer idCandidature, Model model) {
        // 2 Jour apres la date de passage de test , pLus tard parametrable
        // Employee employee = employeeService.getAvailableEmployee();
        Employee employee = employeeService.getById(2); // Plus tard cest la session
        // qui le gere
        Candidature candidature = candidatureService.getById(idCandidature);

        Planing_entretient planing = new Planing_entretient();
        planing.setCandidature(candidature); // liaison candidature → entretien
        planing.setEmployee(employee); // liaison employee → entretien
        planing.setSiege_entreprise(siege_entrepriseService.getById(1)); // par
        // defaut siege principale) ;
        service.save(planing);
        LocalDate today = LocalDate.now();
        int dureeMinutes = societeService.getById(1).getDurre_entretient().intValue();
        service.reserverTempsLibre(planing, today, dureeMinutes);
           List<Emploi_dt_entretient>  val =  serv1.getByPlaning(planing)  ; 

        model.addAttribute("result", "Vous avez passer le test et vous devez vous presenter a  "+siege_entrepriseService.getById(1).getName()+" le "+val.get(0).getDateEntretient()+ " a "+val.get(0).getHeure_debut()+ " jusqua "+val.get(0).getHeure_fin() ) ; 
        return "result";
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
    }
}
