package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository repo;

    public List<Utilisateur> getAll() {
        return repo.findAll();
    }

    public Utilisateur getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Utilisateur checking(String username, String password) {
        return repo.findByUsernameAndPassword( username,  password);
    }

    public void save(Utilisateur obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}