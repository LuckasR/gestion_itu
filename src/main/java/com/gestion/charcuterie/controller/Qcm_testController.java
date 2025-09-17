package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/qcm_test")
public class Qcm_testController {

    @Autowired
    private Qcm_testService service;

    @Autowired
    private CandidatureService candidatureService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("qcm_tests", service.getAll());
        return "qcm_test/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("qcm_test", new Qcm_test());
        model.addAttribute("candidatures", candidatureService.getAll());
        return "qcm_test/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Qcm_test obj) {
        service.save(obj);
        return "redirect:/qcm_test";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("qcm_test", service.getById(id));
        model.addAttribute("candidatureList", candidatureService.getAll());
        return "qcm_test/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Qcm_test obj) {
        service.save(obj);
        return "redirect:/qcm_test";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/qcm_test";
    }}
