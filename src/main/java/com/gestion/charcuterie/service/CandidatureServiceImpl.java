package com.gestion.charcuterie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.charcuterie.model.Candidature;
import com.gestion.charcuterie.model.Detail_candidature;
import com.gestion.charcuterie.repository.CandidatureRepository;
import com.gestion.charcuterie.repository.Detail_candidatureRepository;

@Service
public class CandidatureServiceImpl implements CandidatureService {

    @Autowired
    private CandidatureRepository repo;
    @Autowired
    private Detail_candidatureRepository detail_candidatureRepository;




    public List<Candidature> getAll() {
        return repo.findAll();
    }

    public Candidature getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Candidature obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public Detail_candidature getDetail(Integer candidature_id)
    {
        return detail_candidatureRepository.findByCandidatureId(candidature_id);
    }

    public boolean checkCandidature(){
        
    }
}
