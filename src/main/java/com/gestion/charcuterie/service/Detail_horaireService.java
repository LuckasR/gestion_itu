package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Detail_horaireService {
    List<Detail_horaire> getAll();
    Detail_horaire getById(Integer id);
    void save(Detail_horaire obj);
    void delete(Integer id); 
    public List<Detail_horaire> getByHoraire( Horaire_travail horaireTravail );
}