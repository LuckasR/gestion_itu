package com.gestion.charcuterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.charcuterie.model.Qcm_question;
import java.util.* ; 
public interface Qcm_questionRepository extends JpaRepository<Qcm_question, Integer> {

     List<Qcm_question> findByDepartementId(int departementId);
     
}