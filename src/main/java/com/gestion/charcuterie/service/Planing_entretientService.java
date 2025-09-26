package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;

import java.time.LocalDate;
import java.util.List;

public interface Planing_entretientService {
    List<Planing_entretient> getAll();
    Planing_entretient getById(Integer id);
    void save(Planing_entretient obj);
    void delete(Integer id);
    void reserverTempsLibre( Planing_entretient planing , LocalDate date, int dureeMinutes)  ; 
     Planing_entretient getByCandidat(Candidature candidat) ; 
}