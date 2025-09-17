package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/candidature")
public class CandidatureController {

    @Autowired
    private CandidatureService service;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private Status_traitementService status_traitementService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("candidatures", service.getAll());
        return "candidature/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("candidature", new Candidature());
        model.addAttribute("utilisateurs", utilisateurService.getAll());
        model.addAttribute("annonces", annonceService.getAll());
        model.addAttribute("status_traitements", status_traitementService.getAll());
        return "candidature/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Candidature obj) {
        service.save(obj);
        return "redirect:/candidature";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("candidature", service.getById(id));
        model.addAttribute("utilisateurList", utilisateurService.getAll());
        model.addAttribute("annonceList", annonceService.getAll());
        model.addAttribute("status_traitementList", status_traitementService.getAll());
        return "candidature/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Candidature obj) {
        service.save(obj);
        return "redirect:/candidature";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/candidature";
    }}
