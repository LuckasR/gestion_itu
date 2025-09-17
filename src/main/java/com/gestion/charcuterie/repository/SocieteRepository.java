package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Societe;

public interface SocieteRepository extends JpaRepository<Societe, Integer> {}