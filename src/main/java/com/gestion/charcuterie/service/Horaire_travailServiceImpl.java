package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Horaire_travailServiceImpl implements Horaire_travailService {

    @Autowired
    private Horaire_travailRepository repo;

    public List<Horaire_travail> getAll() {
        return repo.findAll();
    }

    public Horaire_travail getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Horaire_travail obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public Horaire_travail getByJour_semaine(String jourSemaine) {
        return repo.findByJourSemaine(jourSemaine);
    }
}