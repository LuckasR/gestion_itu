package com.gestion.charcuterie.model;
import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "qcm_reponse")
public class Qcm_reponse {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Qcm_question qcm_question;

    
    private String reponse;

    
    private Boolean status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Qcm_question getQcm_question() { return qcm_question; }
    public void setQcm_question(Qcm_question qcm_question) { this.qcm_question = qcm_question; }

    public String getReponse() { return reponse; }
    public void setReponse(String reponse) { this.reponse = reponse; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

}