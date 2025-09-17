package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Information_employeeService {
    List<Information_employee> getAll();
    Information_employee getById(Integer id);
    void save(Information_employee obj);
    void delete(Integer id);
}