package com.gestion.charcuterie.controller;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Controller;
import  org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.charcuterie.model.Candidature;
import com.gestion.charcuterie.model.Employee;
import com.gestion.charcuterie.model.Qcm_test;
import com.gestion.charcuterie.model.Resultat_entretient;
import com.gestion.charcuterie.model.Scoring_candidature;
import com.gestion.charcuterie.service.CandidatureService;
import com.gestion.charcuterie.service.EmployeeService;
import com.gestion.charcuterie.service.Qcm_testService;
import com.gestion.charcuterie.service.Resultat_entretientService;
import com.gestion.charcuterie.service.Scoring_candidatureService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/resultat_entretient")
public class Resultat_entretientController {

    @Autowired
    private Resultat_entretientService service;

    @Autowired
    private Qcm_testService qcm_testService;
    
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CandidatureService candidatureService;

    @Autowired
    private Scoring_candidatureService scoring_candidatureService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("resultat_entretients", service.getAll());
        return "resultat_entretient/index";
    }

    @GetMapping("/create/{candidature_id}")
    public String createForm(@PathVariable Integer candidature_id,HttpSession session,Model model) {
        session.setAttribute("candidature_id",candidature_id);
        session.setAttribute("employe_id",1);
        return "resultat_entretient/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam("pourcentage_satisfaction") Integer pourcentage_satisfaction,HttpSession session) {
        Resultat_entretient r  =new Resultat_entretient();
        Candidature c =candidatureService.getById((Integer)session.getAttribute("candidature_id"));
        Employee e = employeeService.getById((Integer)session.getAttribute("employe_id"));
        r.setEmployee(e);
        r.setCandidature(c);
        r.setPourcentage_satisfaction(BigDecimal.valueOf(pourcentage_satisfaction));
        r.setDate_resultat(LocalDateTime.now());
        service.save(r);
        Scoring_candidature s = new Scoring_candidature();
        s.setCandidature(c);
        Qcm_test qcm = qcm_testService.getByCandidature_id((Integer)session.getAttribute("candidature_id"));
        BigDecimal pourcentage_embauche = qcm.getScore().add(BigDecimal.valueOf(pourcentage_satisfaction));
        BigDecimal valiny = pourcentage_embauche.divide(BigDecimal.valueOf(2),2,RoundingMode.HALF_UP);
        s.setPourcentage_embauche(valiny);
        s.setDate_resultat(LocalDateTime.now());
        scoring_candidatureService.save(s);
        return "redirect:/resultat_entretient";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("resultat_entretient", service.getById(id));
        model.addAttribute("employeeList", employeeService.getAll());
        model.addAttribute("candidatureList", candidatureService.getAll());
        return "resultat_entretient/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Resultat_entretient obj) {
        service.save(obj);
        return "redirect:/resultat_entretient";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/resultat_entretient";
    }}
