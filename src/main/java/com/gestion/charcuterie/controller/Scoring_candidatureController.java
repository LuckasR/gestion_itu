package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/scoring_candidature")
public class Scoring_candidatureController {

    @Autowired
    private Scoring_candidatureService service;

    @Autowired
    private CandidatureService candidatureService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("scoring_candidatures", service.getAll());
        return "scoring_candidature/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("scoring_candidature", new Scoring_candidature());
        model.addAttribute("candidatures", candidatureService.getAll());
        return "scoring_candidature/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Scoring_candidature obj) {
        service.save(obj);
        return "redirect:/scoring_candidature";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("scoring_candidature", service.getById(id));
        model.addAttribute("candidatureList", candidatureService.getAll());
        return "scoring_candidature/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Scoring_candidature obj) {
        service.save(obj);
        return "redirect:/scoring_candidature";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/scoring_candidature";
    }}
