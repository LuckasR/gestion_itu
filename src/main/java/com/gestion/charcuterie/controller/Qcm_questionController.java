package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/qcm_question")
public class Qcm_questionController {

    @Autowired
    private Qcm_questionService service;

    @Autowired
    private DepartementService departementService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("qcm_questions", service.getAll());
        return "qcm_question/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("qcm_question", new Qcm_question());
        model.addAttribute("departements", departementService.getAll());
        return "qcm_question/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Qcm_question obj) {
        service.save(obj);
        return "redirect:/qcm_question";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("qcm_question", service.getById(id));
        model.addAttribute("departementList", departementService.getAll());
        return "qcm_question/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Qcm_question obj) {
        service.save(obj);
        return "redirect:/qcm_question";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/qcm_question";
    }}
