package com.gestion.charcuterie.model;
import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "qcm_test")
public class Qcm_test {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidature_id")
    private Candidature candidature;

    
    private BigDecimal score;

    
    private LocalDateTime date_test;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Candidature getCandidature() { return candidature; }
    public void setCandidature(Candidature candidature) { this.candidature = candidature; }

    public BigDecimal getScore() { return score; }
    public void setScore(BigDecimal score) { this.score = score; }

    public LocalDateTime getDate_test() { return date_test; }
    public void setDate_test(LocalDateTime date_test) { this.date_test = date_test; }

}