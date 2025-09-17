package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Planing_entretientService {
    List<Planing_entretient> getAll();
    Planing_entretient getById(Integer id);
    void save(Planing_entretient obj);
    void delete(Integer id);
}