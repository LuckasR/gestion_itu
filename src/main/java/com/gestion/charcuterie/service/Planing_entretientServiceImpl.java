package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Planing_entretientServiceImpl implements Planing_entretientService {

    @Autowired
    private Planing_entretientRepository repo;

    public List<Planing_entretient> getAll() { return repo.findAll(); }
    public Planing_entretient getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Planing_entretient obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}