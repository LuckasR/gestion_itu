package com.gestion.charcuterie.model;
import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "qcm_question")
public class Qcm_question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    
    private String question;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Departement getDepartement() { return departement; }
    public void setDepartement(Departement departement) { this.departement = departement; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

}