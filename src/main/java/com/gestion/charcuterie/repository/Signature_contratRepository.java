package com.gestion.charcuterie.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.charcuterie.model.Candidature;
import com.gestion.charcuterie.model.Signature_contrat;
 
public interface Signature_contratRepository extends JpaRepository<Signature_contrat, Integer> {
        List<Signature_contrat> findByCandidat(Candidature candidat) ; 
}