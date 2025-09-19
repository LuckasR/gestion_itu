package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.CandidatureAnnonce;
import com.gestion.charcuterie.repository.CandidatureAnnonceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatureAnnonceService {

    private final CandidatureAnnonceRepository repository;

    public CandidatureAnnonceService(CandidatureAnnonceRepository repository) {
        this.repository = repository;
    }

    public List<CandidatureAnnonce> findAll() {
        return repository.findAll();
    }
}
