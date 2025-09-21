package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Scoring_candidature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; // Import manquant
import java.time.LocalDateTime;
import java.math.*;
import java.util.List;




public interface Scoring_candidatureRepository extends JpaRepository<Scoring_candidature, Integer> {
}