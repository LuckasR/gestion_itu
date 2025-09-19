package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatureServiceImpl implements CandidatureService {

    @Autowired
    private CandidatureRepository repo;

    public List<Candidature> getAll() {
        return repo.findAll();
    }

    public Candidature getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

 
    public List<Object[]> getVal( int id) {
        return repo.findbyAnnonce(   id);
    }

    public void save(Candidature obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}