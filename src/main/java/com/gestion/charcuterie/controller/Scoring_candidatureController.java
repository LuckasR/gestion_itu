package com.gestion.charcuterie.controller;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.service.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    
    @Autowired
    private Status_traitementService  status_traitementService;

    @Autowired
    private Detail_candidatureService detailcandidatureService;

    @Autowired
    private Signature_contratService signature_contratService;

    

    @GetMapping
    public String index(Model model) {
        model.addAttribute("scoring_candidatures", service.getAll());
        return "scoring_candidature/index";
    }

    @PostMapping(value = "/filtre")
    // @ResponseBody
    public /* List<Scoring_candidature> */ String filter(
            @RequestParam(value = "date_debut", required = false) LocalDateTime date_debut,
            @RequestParam(value = "date_fin", required = false) LocalDateTime date_fin,
            @RequestParam(value = "pourcentage_embauche_min", required = false) BigDecimal pourcentage_embauche_min,
            @RequestParam(value = "pourcentage_embauche_max", required = false) BigDecimal pourcentage_embauche_max,
            Model model) {
        List<Scoring_candidature> scoring_candidatures = service.filter(date_debut, date_fin, pourcentage_embauche_min,
                pourcentage_embauche_max);
        // return scoring_candidatures;
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

    @GetMapping("/validate/{id}")
    public String validate(@PathVariable Integer id, Model model) {
        Candidature c = candidatureService.getById(id);
        Detail_candidature dc = candidatureService.getDetail(id);
        Signature_contrat sc  = new Signature_contrat() ; 
        sc.setCandidat(c);
        sc.setStatus(  status_traitementService.getById(1)); 
        signature_contratService.save(sc); 
        System.out.println(id);
        return "redirect:/";  
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
    }
}
