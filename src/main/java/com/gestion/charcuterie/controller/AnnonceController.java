package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/annonce")
public class AnnonceController {

    @Autowired
    private AnnonceService service;

    @Autowired
    private DepartementService departementService;

    @Autowired
    private Niveau_etudeService niveau_etudeService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private Type_contratService type_contratService;

    @Autowired
    private StatusService statusService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("annonces", service.getAll());
        return "annonce/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("annonce", new Annonce());
        model.addAttribute("departements", departementService.getAll());
        model.addAttribute("niveau_etudes", niveau_etudeService.getAll());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("type_contrats", type_contratService.getAll());
        model.addAttribute("statuss", statusService.getAll());
        return "annonce/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Annonce obj) {
        service.save(obj);
        return "redirect:/annonce";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("annonce", service.getById(id));
        model.addAttribute("departementList", departementService.getAll());
        model.addAttribute("niveau_etudeList", niveau_etudeService.getAll());
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("type_contratList", type_contratService.getAll());
        model.addAttribute("statusList", statusService.getAll());
        return "annonce/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Annonce obj) {
        service.save(obj);
        return "redirect:/annonce";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/annonce";
    }}
