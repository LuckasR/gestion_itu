package com.gestion.charcuterie.service;

import java.util.List;

import com.gestion.charcuterie.model.Contrat_employee;

public interface Contrat_employeeService {

    List<Contrat_employee> getAll();

    Contrat_employee getById(Integer id);

    void save(Contrat_employee obj);

    void delete(Integer id);
}
