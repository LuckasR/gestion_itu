package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository repo;

    public List<Admin> getAll() { return repo.findAll(); }
    public Admin getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Admin obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}