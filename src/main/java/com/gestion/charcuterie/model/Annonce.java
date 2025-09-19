package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "annonce")
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @ManyToOne
    @JoinColumn(name = "niveau_etude_id")
    private Niveau_etude niveau_etude;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "type_contrat_id")
    private Type_contrat type_contrat;

    private String description;

    private Integer age_requis;

    private Integer experience_requis;


    private LocalDate date_publication;

    private LocalDate date_expiration;

    private BigDecimal salaire;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;




    
    public Integer getAge_requis() {
        return age_requis;
    }

    public void setAge_requis(Integer age_requis) {
        this.age_requis = age_requis;
    }
    
    public Integer getExperience_requis() {
        return experience_requis;
    }

    public void setExperience_requis(Integer experience_requis) {
        this.experience_requis = experience_requis;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Niveau_etude getNiveau_etude() {
        return niveau_etude;
    }

    public void setNiveau_etude(Niveau_etude niveau_etude) {
        this.niveau_etude = niveau_etude;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Type_contrat getType_contrat() {
        return type_contrat;
    }

    public void setType_contrat(Type_contrat type_contrat) {
        this.type_contrat = type_contrat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(LocalDate date_publication) {
        this.date_publication = date_publication;
    }

    public LocalDate getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(LocalDate date_expiration) {
        this.date_expiration = date_expiration;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getSalaire() {
        return salaire;
    }

    public void setSalaire(BigDecimal salaire) {
        this.salaire = salaire;
    }

}