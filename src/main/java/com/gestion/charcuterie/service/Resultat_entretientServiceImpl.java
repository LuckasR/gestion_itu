package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Resultat_entretientServiceImpl implements Resultat_entretientService {

    @Autowired
    private Resultat_entretientRepository repo;

    public List<Resultat_entretient> getAll() { return repo.findAll(); }
    public Resultat_entretient getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Resultat_entretient obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}