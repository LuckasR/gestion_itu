package com.gestion.charcuterie.controller;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class AuthController {
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/candidature/inscription")
    public String inscriptionForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "candidature/inscription";
    }

    @PostMapping("/candidature/inscription")
    public String inscriptionCandidat(
        @Valid @ModelAttribute("utilisateur") Utilisateur utilisateur,
        BindingResult bindingResult,
        @RequestParam String confirmPassword,
        Model model
    ){
        // Validation des mots de passe
        if (!utilisateur.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Les mots de passe ne correspondent pas");
            return "candidature/inscription";
        }

        // Validation des erreurs de binding
        if (bindingResult.hasErrors()) {
            return "candidature/inscription";
        }


        // Vérification de l'unicité du nom d'utilisateur
        if (utilisateurRepository.existsByUsername(utilisateur.getUsername())) {
            model.addAttribute("error", "Ce nom d'utilisateur est déjà utilisé");
            return "candidature/inscription";
        }

        // Encodage du mot de passe et sauvegarde
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        utilisateurRepository.save(utilisateur);

        model.addAttribute("success", "Compte créé avec succès ! Vous pouvez maintenant vous connecter.");
        return "candidature/connexion";
    }
}
