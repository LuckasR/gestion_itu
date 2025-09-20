package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Qcm_test;
import org.springframework.data.repository.query.Param; // Import manquant
import org.springframework.data.jpa.repository.Query;

public interface Qcm_testRepository extends JpaRepository<Qcm_test, Integer> {
    @Query(value="SELECT * FROM qcm_test WHERE candidature_id =:candidature_id",nativeQuery=true)
    public Qcm_test getByCandidature_id(@Param("candidature_id") Integer candidature_id);
}