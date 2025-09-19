package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Qcm_test;
import java.util.* ;
public interface Qcm_testRepository extends JpaRepository<Qcm_test, Integer> {
    List<Qcm_test> findByCandidatureId(int candidatureId);

}