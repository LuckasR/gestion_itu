package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Organisme_socialService {
    List<Organisme_social> getAll();
    Organisme_social getById(Integer id);
    void save(Organisme_social obj);
    void delete(Integer id);
}