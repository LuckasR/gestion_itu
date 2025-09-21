package com.gestion.charcuterie.controller;

import  java.math.BigDecimal;
import  java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.charcuterie.model.Scoring_candidature;
import com.gestion.charcuterie.service.CandidatureService;
import com.gestion.charcuterie.service.Scoring_candidatureService;


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

    @PostMapping(value="/filtre")
    //@ResponseBody
    public /*List<Scoring_candidature>*/ String filter(@RequestParam(value="date_debut",required = false) LocalDateTime date_debut,@RequestParam(value="date_fin",required = false) LocalDateTime date_fin,@RequestParam(value="pourcentage_embauche_min",required = false) BigDecimal pourcentage_embauche_min,@RequestParam(value="pourcentage_embauche_max",required = false) BigDecimal pourcentage_embauche_max,Model model){
        List<Scoring_candidature> scoring_candidatures = service.filter(date_debut, date_fin, pourcentage_embauche_min, pourcentage_embauche_max); 
        //return scoring_candidatures;
         // ⚠️ important : injecter la liste dans le model
        model.addAttribute("scoring_candidatures", scoring_candidatures);
        return "scoring_candidature/listeAjax::scoring_candidatures";
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
