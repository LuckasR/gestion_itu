package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Detail_horaireServiceImpl implements Detail_horaireService {

    @Autowired
    private Detail_horaireRepository repo;

    public List<Detail_horaire> getAll() {
        return repo.findAll();
    }

    public List<Detail_horaire> getByHoraire( Horaire_travail horaireTravail ) {
        return repo.findByHoraireTravail( horaireTravail);
    }

    public Detail_horaire getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Detail_horaire obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}