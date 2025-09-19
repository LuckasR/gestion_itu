package com.gestion.charcuterie.dto;
import java.util.*;

public class UserAnswerDTO {
    private Long questionId;
    private Long reponseId; // l'id de la réponse choisie
    private Map<Long, Long> reponses;

    // Getters et Setters
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getReponseId() {
        return reponseId;
    }

    public void setReponseId(Long reponseId) {
        this.reponseId = reponseId;
    }


    public Map<Long, Long> getReponses() {
        return reponses;
    }

    public void setReponses(Map<Long, Long> reponses) {
        this.reponses = reponses;
    }
}
