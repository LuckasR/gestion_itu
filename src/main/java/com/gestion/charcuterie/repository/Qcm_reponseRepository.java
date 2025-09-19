package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion.charcuterie.model.Qcm_reponse;
import java.util.* ; 

public interface Qcm_reponseRepository extends JpaRepository<Qcm_reponse, Integer> { 


    @Query(value = "select * from qcm_reponse where question_id = :questId " , nativeQuery = true)
    List<Qcm_reponse> findByQuestion_Id(@Param("questId") int id) ; 
 
    // List<Qcm_reponse> findByQuestionid(int questionId);
 
}