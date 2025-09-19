package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface UtilisateurService {
    List<Utilisateur> getAll();
    Utilisateur getById(Integer id);
    void save(Utilisateur obj);
    void delete(Integer id);
    Utilisateur checking(String username, String password) ; 
}