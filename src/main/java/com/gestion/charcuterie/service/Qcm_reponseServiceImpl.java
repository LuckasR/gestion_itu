package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Qcm_reponseServiceImpl implements Qcm_reponseService {

    @Autowired
    private Qcm_reponseRepository repo;

    public List<Qcm_reponse> getAll() { return repo.findAll(); }
    public Qcm_reponse getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Qcm_reponse obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}