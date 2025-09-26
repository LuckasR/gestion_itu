package com.gestion.charcuterie.repository;
import java.time.LocalDate;
import java.util.List;
import com.gestion.charcuterie.model.* ; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface Emploi_dt_entretientRepository extends JpaRepository<Emploi_dt_entretient, Integer> {

    List<Emploi_dt_entretient> findByPlaningEntretient(Planing_entretient planingEntretient);
    List<Emploi_dt_entretient> findByDateEntretient(LocalDate  dateEntretient );

     
}