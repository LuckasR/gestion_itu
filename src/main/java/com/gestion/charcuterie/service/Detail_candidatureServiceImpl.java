package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Detail_candidatureServiceImpl implements Detail_candidatureService {

    @Autowired
    private Detail_candidatureRepository repo;

    public List<Detail_candidature> getAll() { return repo.findAll(); }
    public Detail_candidature getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Detail_candidature obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
    public Detail_candidature findByCandidatureId(Integer candidature_id){
        return repo.findByCandidatureId(candidature_id);
    } 
}