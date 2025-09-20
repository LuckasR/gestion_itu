package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; // Import manquant

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
}