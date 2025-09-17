package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface AdminService {
    List<Admin> getAll();
    Admin getById(Integer id);
    void save(Admin obj);
    void delete(Integer id);
}