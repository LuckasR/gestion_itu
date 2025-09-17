package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {}