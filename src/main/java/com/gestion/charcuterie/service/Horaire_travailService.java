package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Horaire_travailService {
    List<Horaire_travail> getAll();
    Horaire_travail getById(Integer id);
    Horaire_travail getByJour_semaine(String jourSemaine);
    void save(Horaire_travail obj);
    void delete(Integer id);
    
}