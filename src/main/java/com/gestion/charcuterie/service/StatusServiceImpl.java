package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository repo;

    public List<Status> getAll() { return repo.findAll(); }
    public Status getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Status obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}