package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "candidature")
public class Candidature {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "L'utilisateur est obligatoire")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "annonce_id", nullable = false)
    @NotNull(message = "L'annonce est obligatoire")
    private Annonce annonce;

    @NotNull(message = "La date de candidature est obligatoire")
    @Column(nullable = false)
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