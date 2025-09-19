package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Qcm_questionService {
    List<Qcm_question> getAll();
    Qcm_question getById(Integer id);
    void save(Qcm_question obj);
    void delete(Integer id);
    Qcm_question getRandomQuestionByDepartement(int departementId) ; 
    List<Qcm_reponse> getReponses(int questionId) ; 
    double getPoint(int questionId ,int nbrPoints , List<Integer> reponsesId ) ; 
     List<Qcm_question> getQuestionsByDepartement(int departementId)  ;
}