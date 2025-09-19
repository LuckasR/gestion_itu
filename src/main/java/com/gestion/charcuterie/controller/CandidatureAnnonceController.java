package com.gestion.charcuterie.controller;

import com.gestion.charcuterie.model.CandidatureAnnonce;
import com.gestion.charcuterie.service.CandidatureAnnonceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CandidatureAnnonceController {

    private final CandidatureAnnonceService service;

    public CandidatureAnnonceController(CandidatureAnnonceService service) {
        this.service = service;
    }

    @GetMapping("/candidature-annonce")
    public String list(Model model) {
        List<CandidatureAnnonce> candidatures = service.findAll();
        model.addAttribute("candidatures", candidatures);
        return "candidature_annonce/list"; // Vue Thymeleaf
    }


    
    @GetMapping("/candidature/{id}")
    public String detail_candidature( @PathVariable Integer id   , Model model) {
        List<CandidatureAnnonce> candidatures = service.findAll();
        model.addAttribute("candidatures", candidatures);
        return "candidature_annonce/detail"; // Vue Thymeleaf
    }

}

 