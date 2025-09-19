package com.gestion.charcuterie.controller;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublicController {

    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private DepartementService departementService;

    @Autowired
    private Type_contratService type_contratService;


    /**
     * Page d'accueil publique
     */
    @GetMapping("/accueil")
    public String accueil() {
        return "public/accueil";
    }

    /**
     * Page des offres d'emploi publiques avec gestion des filtres.
     * Gère à la fois l'affichage initial (toutes les offres) et les résultats filtrés.
     */
    @GetMapping("/offres")
    public String offres(
            @RequestParam(required = false) Integer departementId,
            @RequestParam(required = false) Integer typeContratId,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String filtrer,
            Model model) {

        // Si le paramètre 'filtrer' n'est pas présent, ignorer tous les filtres
        List<Annonce> annonces;
        if (filtrer == null) {
            annonces = annonceService.getAll();
            // On ignore les filtres, inutile de réaffecter les variables
        } else {
            var annoncesStream = annonceService.getAll().stream();
            if (departementId != null) {
                annoncesStream = annoncesStream.filter(a -> a.getDepartement() != null && a.getDepartement().getId().equals(departementId));
            }
            if (typeContratId != null) {
                annoncesStream = annoncesStream.filter(a -> a.getType_contrat() != null && a.getType_contrat().getId().equals(typeContratId));
            }
            if (search != null && !search.trim().isEmpty()) {
                String searchLower = search.toLowerCase();
                annoncesStream = annoncesStream.filter(a -> a.getTitle() != null && a.getTitle().toLowerCase().contains(searchLower));
            }
            annonces = annoncesStream.toList();
        }

        model.addAttribute("annonces", annonces);
        model.addAttribute("departements", departementService.getAll());
        model.addAttribute("type_contrats", type_contratService.getAll());

    // Ajout de la date courante pour Thymeleaf
    model.addAttribute("now", java.time.LocalDate.now());

        // Conserver l'état des filtres dans la vue
        model.addAttribute("selectedDepartement", departementId);
        model.addAttribute("selectedTypeContrat", typeContratId);
        model.addAttribute("searchTerm", search);

        return "public/offres";
    }

    @GetMapping("/offre/{id}")
    public String detailOffre(@PathVariable Integer id, Model model) {
        Annonce annonce = annonceService.getById(id);
        if (annonce == null) {
            return "redirect:/offres";
        }
        model.addAttribute("annonce", annonce);
        model.addAttribute("now", java.time.LocalDate.now());
        return "public/detail-offre";
    }

    /**
     * Page de contact
     */
    @GetMapping("/contact")
    public String contact() {
        return "public/contact";
    }

    /**
     * Page de connexion
     */
    @GetMapping("/connexion")
    public String connexion() {
        return "public/connexion";
    }
}
