package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface CandidatureService {
    List<Candidature> getAll();
    Candidature getById(Integer id);
    void save(Candidature obj);
    void delete(Integer id);
}