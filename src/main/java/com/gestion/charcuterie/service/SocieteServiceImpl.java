package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocieteServiceImpl implements SocieteService {

    @Autowired
    private SocieteRepository repo;

    public List<Societe> getAll() { return repo.findAll(); }
    public Societe getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Societe obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}