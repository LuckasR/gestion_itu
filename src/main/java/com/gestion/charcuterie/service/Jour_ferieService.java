package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface Jour_ferieService {
    List<Jour_ferie> getAll();
    Jour_ferie getById(Integer id);
    void save(Jour_ferie obj);
    void delete(Integer id);
     boolean verifyJourFerie(LocalDateTime date) ; 
     boolean verifyJourFerie(LocalDate  date) ; 
}