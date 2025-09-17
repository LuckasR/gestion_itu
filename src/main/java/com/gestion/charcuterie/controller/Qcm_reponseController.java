package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/qcm_reponse")
public class Qcm_reponseController {

    @Autowired
    private Qcm_reponseService service;

    @Autowired
    private Qcm_questionService qcm_questionService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("qcm_reponses", service.getAll());
        return "qcm_reponse/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("qcm_reponse", new Qcm_reponse());
        model.addAttribute("qcm_questions", qcm_questionService.getAll());
        return "qcm_reponse/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Qcm_reponse obj) {
        service.save(obj);
        return "redirect:/qcm_reponse";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("qcm_reponse", service.getById(id));
        model.addAttribute("qcm_questionList", qcm_questionService.getAll());
        return "qcm_reponse/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Qcm_reponse obj) {
        service.save(obj);
        return "redirect:/qcm_reponse";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/qcm_reponse";
    }}
