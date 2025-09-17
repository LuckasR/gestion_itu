package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Assurance_social_employeeService {
    List<Assurance_social_employee> getAll();
    Assurance_social_employee getById(Integer id);
    void save(Assurance_social_employee obj);
    void delete(Integer id);
}