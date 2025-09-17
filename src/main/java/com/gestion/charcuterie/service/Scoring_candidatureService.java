package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Scoring_candidatureService {
    List<Scoring_candidature> getAll();
    Scoring_candidature getById(Integer id);
    void save(Scoring_candidature obj);
    void delete(Integer id);
}