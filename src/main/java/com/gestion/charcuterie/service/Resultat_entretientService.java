package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Resultat_entretientService {
    List<Resultat_entretient> getAll();

    Resultat_entretient getById(Integer id);

    void save(Resultat_entretient obj);

    void delete(Integer id);


}