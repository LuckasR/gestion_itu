package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Jour_ferieServiceImpl implements Jour_ferieService {

    @Autowired
    private Jour_ferieRepository repo;

    public List<Jour_ferie> getAll() {
        return repo.findAll();
    }

    public Jour_ferie getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Jour_ferie obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public boolean verifyJourFerie(LocalDateTime date) {
        List<Jour_ferie> joursFeries = repo.findAll();
        for (Jour_ferie jourFerie : joursFeries) {
            if (jourFerie.getDate_ferie().isEqual(date.toLocalDate())) {
                return true; // La date est un jour férié
            }
        }
        return false; // La date n'est pas un jour férié 
    }

    public boolean verifyJourFerie(LocalDate  date) {
        List<Jour_ferie> joursFeries = repo.findAll();
        for (Jour_ferie jourFerie : joursFeries) {
            if (jourFerie.getDate_ferie().isEqual(date)) {
                return true; // La date est un jour férié
            }
        }
        return false; // La date n'est pas un jour férié 
    }
}
 