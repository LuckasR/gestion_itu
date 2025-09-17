package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Contrat_employeeService {
    List<Contrat_employee> getAll();
    Contrat_employee getById(Integer id);
    void save(Contrat_employee obj);
    void delete(Integer id);
}