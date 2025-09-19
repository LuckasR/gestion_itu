package com.gestion.charcuterie.repository;

import com.gestion.charcuterie.model.CandidatureAnnonce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatureAnnonceRepository extends JpaRepository<CandidatureAnnonce, Integer> {

      @Query(value = "select * from detail_candidature as dc join candidature as c on c.id = dc.candidature_id where c.annonce_id = : annonce_id" , nativeQuery = true)
    List<Object[]> findbyAnnonce(@Param("annonce_id") int id) ; 
  
}
