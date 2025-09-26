package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Signature_contratServiceImpl implements Signature_contratService {

    @Autowired
    private Signature_contratRepository repo;

    public List<Signature_contrat> getAll() {
        return repo.findAll();
    }
    
    public  List<Signature_contrat>  getByCandidat(Candidature candidat) {
        return repo.findByCandidat( candidat) ; 
    }
 
    public Signature_contrat getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Signature_contrat obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}