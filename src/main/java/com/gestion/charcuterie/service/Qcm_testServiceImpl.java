package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Qcm_testServiceImpl implements Qcm_testService {

    @Autowired
    private Qcm_testRepository repo;

    public List<Qcm_test> getAll() { return repo.findAll(); }
    public Qcm_test getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Qcm_test obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}