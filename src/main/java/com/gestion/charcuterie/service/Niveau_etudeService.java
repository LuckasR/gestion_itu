package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Niveau_etudeService {
    List<Niveau_etude> getAll();
    Niveau_etude getById(Integer id);
    void save(Niveau_etude obj);
    void delete(Integer id);
}