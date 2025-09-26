package com.gestion.charcuterie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Horaire_travail;

public interface Horaire_travailRepository extends JpaRepository<Horaire_travail, Integer> {

    Horaire_travail findByJourSemaine(String jourSemaine);
}