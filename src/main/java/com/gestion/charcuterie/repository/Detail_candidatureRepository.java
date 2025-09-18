package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; // Import manquant
import com.gestion.charcuterie.model.Detail_candidature;

public interface Detail_candidatureRepository extends JpaRepository<Detail_candidature, Integer> {
    @Query(value="SELECT * FROM detail_candidature WHERE candidature_id = :candidature_id",nativeQuery=true)
    Detail_candidature findByCandidatureId(@Param("candidature_id") Integer candidature_id);
}