package com.gestion.charcuterie.controller;

import com.gestion.charcuterie.model.Utilisateur;
import com.gestion.charcuterie.service.UtilisateurServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UserController {

    private final UtilisateurServiceImpl utilisateurService;

    public UserController(UtilisateurServiceImpl utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    // GET : tous les utilisateurs
    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return utilisateurService.getAll();
    }

    // GET : utilisateur par ID
    @GetMapping("/{id}")
    public Utilisateur getUserById(@PathVariable Integer id) {
        return utilisateurService.getById(id);
    }

    // POST : créer un utilisateur
    @PostMapping
    public Utilisateur createUser(@RequestBody Utilisateur utilisateur) {
        utilisateurService.save(utilisateur);
        return utilisateur;
    }

    // PUT : mettre à jour un utilisateur
    @PutMapping("/{id}")
    public Utilisateur updateUser(@PathVariable Integer id, @RequestBody Utilisateur utilisateur) {
        Utilisateur existing = utilisateurService.getById(id);
        if (existing != null) {
            existing.setUsername(utilisateur.getUsername());
            existing.setPassword(utilisateur.getPassword());
            existing.setEmail(utilisateur.getEmail());
            utilisateurService.save(existing);
            return existing;
        }
        return null;
    }

    // DELETE : supprimer un utilisateur
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        utilisateurService.delete(id);
        return "Utilisateur supprimé ✅";
    }

    // GET : vérifier login (username + password)
    @GetMapping("/check")
    public Utilisateur checkLogin(@RequestParam String username, @RequestParam String password) {
        return utilisateurService.checking(username, password);
    }
}
