package com.gestion.charcuterie.controller;

import  com.gestion.charcuterie.model.*;
import  com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/contrat_employee")
public class Contrat_employeeController {

    @Autowired
    private Contrat_employeeService service;

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Type_contratService type_contratService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("contrat_employees", service.getAll());
        return "contrat_employee/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("contrat_employee", new Contrat_employee());
        model.addAttribute("admins", adminService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("type_contrats", type_contratService.getAll());
        return "contrat_employee/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Contrat_employee obj) {
        service.save(obj);
        return "redirect:/contrat_employee";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("contrat_employee", service.getById(id));
        model.addAttribute("adminList", adminService.getAll());
        model.addAttribute("employeeList", employeeService.getAll());
        model.addAttribute("type_contratList", type_contratService.getAll());
        return "contrat_employee/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Contrat_employee obj) {
        service.save(obj);
        return "redirect:/contrat_employee";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/contrat_employee";
    }}
