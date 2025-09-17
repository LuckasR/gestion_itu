package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface SocieteService {
    List<Societe> getAll();
    Societe getById(Integer id);
    void save(Societe obj);
    void delete(Integer id);
}