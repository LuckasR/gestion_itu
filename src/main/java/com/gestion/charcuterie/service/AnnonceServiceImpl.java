package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    @Autowired
    private AnnonceRepository repo;

    public List<Annonce> getAll() { return repo.findAll(); }
    public Annonce getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Annonce obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}