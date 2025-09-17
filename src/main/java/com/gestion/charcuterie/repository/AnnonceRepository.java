package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {}