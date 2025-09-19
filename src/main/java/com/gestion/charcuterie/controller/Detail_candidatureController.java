package com.gestion.charcuterie.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import com.gestion.charcuterie.model.Annonce;
import com.gestion.charcuterie.model.Candidature;
import com.gestion.charcuterie.model.Utilisateur;
import com.gestion.charcuterie.model.Detail_candidature;
import com.gestion.charcuterie.model.Genre;
import com.gestion.charcuterie.model.Status_traitement;
import com.gestion.charcuterie.service.AnnonceService;
import com.gestion.charcuterie.service.CandidatureService;
import com.gestion.charcuterie.service.Detail_candidatureService;
import com.gestion.charcuterie.service.GenreService;
import com.gestion.charcuterie.service.Niveau_etudeService;
import com.gestion.charcuterie.service.Status_traitementService;
import com.gestion.charcuterie.service.UtilisateurService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/detail_candidature")
public class Detail_candidatureController {

    @Autowired
    private Detail_candidatureService service;

    @Autowired
    private CandidatureService candidatureService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private Status_traitementService status_traitementService;

    @Autowired
    private Niveau_etudeService niveau;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("detail_candidatures", service.getAll());
        return "detail_candidature/index";
    }

@GetMapping("/create/{annonce_id}")
public String createForm(@PathVariable Integer annonce_id, HttpSession session, Model model) {
    session.setAttribute("annonce_id", annonce_id);
    session.setAttribute("user_id", 1);

    model.addAttribute("genres", genreService.getAll());
    model.addAttribute("niveau", niveau.getAll());

    // 🔥 très important : ajouter un objet vide
    model.addAttribute("detailCandidature", new Detail_candidature());

    return "detail_candidature/create";
}


 @PostMapping("/save")
    public String save(@ModelAttribute("detailCandidature") Detail_candidature detailCandidature,
                       @RequestParam("cvFile") MultipartFile cvFile,
                       @RequestParam(value = "lmFile", required = false) MultipartFile lmFile,
                       HttpSession session) {

        // Récupération de l'annonce et de l'utilisateur
        Integer annonce_id = (Integer) session.getAttribute("annonce_id");
        Integer user_id = (Integer) session.getAttribute("user_id");
        Utilisateur u = utilisateurService.getById(user_id);
        Annonce a = annonceService.getById(annonce_id);

        // Création de la candidature
        Candidature c = new Candidature();
        c.setAnnonce(a);
        c.setUtilisateur(u);
        c.setDate_candidature(LocalDate.now());

        // Gestion des fichiers
        try {
            if (cvFile != null && !cvFile.isEmpty()) {
                String uploadDir = "uploads/cv/";
                String fileName = System.currentTimeMillis() + "_" + cvFile.getOriginalFilename();
                Path path = Paths.get(uploadDir + fileName);
                Files.createDirectories(path.getParent());
                Files.write(path, cvFile.getBytes());
                detailCandidature.setCv("cv/" + fileName);
            }

            if (lmFile != null && !lmFile.isEmpty()) {
                String uploadDir = "uploads/lm/";
                String fileName = System.currentTimeMillis() + "_" + lmFile.getOriginalFilename();
                Path path = Paths.get(uploadDir + fileName);
                Files.createDirectories(path.getParent());
                Files.write(path, lmFile.getBytes());
                detailCandidature.setLm("lm/" + fileName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Vérification de conformité
        Status_traitement stTrue = status_traitementService.getById(2); // Conforme
        Status_traitement stFalse = status_traitementService.getById(3); // Non conforme

        if (!service.checkConformite(a, detailCandidature)) {
            c.setStatus_traitement(stFalse);
        } else {
            c.setStatus_traitement(stTrue);
        }

        // Sauvegarde
        candidatureService.save(c);
        detailCandidature.setCandidature(c);
        service.save(detailCandidature);

        if (!service.checkConformite(a, detailCandidature)) {
            return "redirect:/";
        } else {
            return "redirect:/qcm_test";
        }
    }

    // @PostMapping("/save")
    // public String save(@RequestParam("genre_id") String genre_id,
    //         @RequestParam("duree_experience") String duree_experience,
    //         @RequestParam("skills") String skills,
    //         @RequestParam("motivation") String motivation,
    //         @RequestParam("experience_professionnelle") String experience_professionnelle,
    //         @RequestParam("address") String address,
    //         @RequestParam("residence") String residence,
    //         HttpSession session,
    //         @RequestParam("cv") MultipartFile cv,
    //         @RequestParam("lm") MultipartFile lm,
    //         @RequestParam("cin") String cin) {

    //     Detail_candidature obj = new Detail_candidature();
    //     Genre genre = genreService.getById(Integer.parseInt(genre_id));
    //     obj.setDuree_experience(duree_experience);
    //     obj.setSkills(skills);
    //     obj.setMotivation(motivation);
    //     obj.setExperience_professionnelle(experience_professionnelle);
    //     obj.setAddress(address);
    //     obj.setCin(cin);
    //     obj.setGenre(genre);
    //     obj.setResidence(residence);
    //     Integer annonce_id = (Integer) session.getAttribute("annonce_id");
    //     Integer user_id = (Integer) session.getAttribute("user_id");
    //     Utilisateur u = utilisateurService.getById(user_id);
    //     Annonce a = annonceService.getById(annonce_id);
    //     Status_traitement stTrue = status_traitementService.getById(2);
    //     Status_traitement stFalse = status_traitementService.getById(3);

    //     Candidature c = new Candidature();
    //     c.setAnnonce(a);
    //     c.setUtilisateur(u);
    //     c.setDate_candidature(LocalDate.now());

    //     try {
    //         if (!cv.isEmpty()) {
    //             String uploadDir = "uploads/cv/";
    //             String fileName = System.currentTimeMillis() + '_' + cv.getOriginalFilename();
    //             Path path = Paths.get(uploadDir + fileName);
    //             Files.createDirectories(path.getParent());
    //             Files.write(path, cv.getBytes());
    //             obj.setCv("cv/" + fileName);
    //         }
    //         if (!lm.isEmpty()) {
    //             String uploadDir = "uploads/lm/";
    //             String fileName = System.currentTimeMillis() + '_' + lm.getOriginalFilename();
    //             Path path = Paths.get(uploadDir + fileName);
    //             Files.createDirectories(path.getParent());
    //             Files.write(path, lm.getBytes());
    //             obj.setLm("lm/" + fileName);
    //         }

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     if (service.checkConformite(a, obj) == false) {
    //         c.setStatus_traitement(stFalse);
    //         candidatureService.save(c);
    //         obj.setCandidature(c);
    //         service.save(obj);
    //         return "detail_candidature/non_conforme";

    //     } else {
    //         c.setStatus_traitement(stTrue);
    //         candidatureService.save(c);
    //         obj.setCandidature(c);
    //         service.save(obj);
    //         return "redirect:/qcm_test";
    //     }

    // }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("detail_candidature", service.getById(id));
        model.addAttribute("candidatureList", candidatureService.getAll());
        model.addAttribute("genreList", genreService.getAll());
        return "detail_candidature/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Detail_candidature obj) {
        service.save(obj);
        return "redirect:/detail_candidature";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/detail_candidature";
    }
}
