package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAll() { return repo.findAll(); }
    public Employee getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Employee obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}