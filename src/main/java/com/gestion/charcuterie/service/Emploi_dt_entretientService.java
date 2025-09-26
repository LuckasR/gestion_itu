package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;

import java.time.LocalDate;
import java.util.List;

public interface Emploi_dt_entretientService {
    List<Emploi_dt_entretient> getAll();
    Emploi_dt_entretient getById(Integer id);
    void save(Emploi_dt_entretient obj);
    void delete(Integer id);
     List<Emploi_dt_entretient> getByPlaning(Planing_entretient planingEntretient)  ; 
     List<Emploi_dt_entretient> getByDate(LocalDate dateEntretient);
}