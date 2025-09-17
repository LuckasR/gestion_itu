package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Qcm_questionServiceImpl implements Qcm_questionService {

    @Autowired
    private Qcm_questionRepository repo;

    public List<Qcm_question> getAll() { return repo.findAll(); }
    public Qcm_question getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Qcm_question obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}