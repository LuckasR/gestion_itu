package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface DepartementService {
    List<Departement> getAll();
    Departement getById(Integer id);
    void save(Departement obj);
    void delete(Integer id);
}