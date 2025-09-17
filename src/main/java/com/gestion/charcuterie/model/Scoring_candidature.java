package com.gestion.charcuterie.model;
import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "scoring_candidature")
public class Scoring_candidature {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidature_id")
    private Candidature candidature;

    
    private BigDecimal pourcentage_embauche;

    
    private String date_resultat;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Candidature getCandidature() { return candidature; }
    public void setCandidature(Candidature candidature) { this.candidature = candidature; }

    public BigDecimal getPourcentage_embauche() { return pourcentage_embauche; }
    public void setPourcentage_embauche(BigDecimal pourcentage_embauche) { this.pourcentage_embauche = pourcentage_embauche; }

    public String getDate_resultat() { return date_resultat; }
    public void setDate_resultat(String date_resultat) { this.date_resultat = date_resultat; }

}