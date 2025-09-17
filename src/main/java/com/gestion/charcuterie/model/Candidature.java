package com.gestion.charcuterie.model;
import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "candidature")
public class Candidature {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;

    
    private LocalDate date_candidature;

    @ManyToOne
    @JoinColumn(name = "status_traitement_id")
    private Status_traitement status_traitement;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public Annonce getAnnonce() { return annonce; }
    public void setAnnonce(Annonce annonce) { this.annonce = annonce; }

    public LocalDate getDate_candidature() { return date_candidature; }
    public void setDate_candidature(LocalDate date_candidature) { this.date_candidature = date_candidature; }

    public Status_traitement getStatus_traitement() { return status_traitement; }
    public void setStatus_traitement(Status_traitement status_traitement) { this.status_traitement = status_traitement; }

}