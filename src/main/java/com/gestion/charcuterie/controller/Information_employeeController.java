package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/information_employee")
public class Information_employeeController {

    @Autowired
    private Information_employeeService service;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Type_contratService type_contratService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("information_employees", service.getAll());
        return "information_employee/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("information_employee", new Information_employee());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("type_contrats", type_contratService.getAll());
        return "information_employee/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Information_employee obj) {
        service.save(obj);
        return "redirect:/information_employee";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("information_employee", service.getById(id));
        model.addAttribute("employeeList", employeeService.getAll());
        model.addAttribute("type_contratList", type_contratService.getAll());
        return "information_employee/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Information_employee obj) {
        service.save(obj);
        return "redirect:/information_employee";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/information_employee";
    }}
