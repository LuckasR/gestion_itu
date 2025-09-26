package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Emploi_dt_entretientServiceImpl implements Emploi_dt_entretientService {

    @Autowired
    private Emploi_dt_entretientRepository repo;

    public List<Emploi_dt_entretient> getAll() {
        return repo.findAll();
    }

    public Emploi_dt_entretient getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public List<Emploi_dt_entretient> getByPlaning(Planing_entretient planingEntretient) {
        return repo.findByPlaningEntretient(planingEntretient);
    }

    public List<Emploi_dt_entretient> getByDate(LocalDate dateEntretient) {
        return repo.findByDateEntretient(dateEntretient);
    }

    public void save(Emploi_dt_entretient obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}