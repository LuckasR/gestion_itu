package com.gestion.charcuterie.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_candidature")
public class Detail_candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidature_id")    
    private Candidature candidature;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "niveau_etude_id")
    private Niveau_etude niveau;


    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;
 

    private String duree_experience;

    private String skills;

    private String motivation;

    private String experience_professionnelle;

    private String address;

    private String cv;

    private String lm;

    private String cin;

    private String residence;

    private LocalDate date_naissance;
 
    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Niveau_etude getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau_etude niveau) {
        this.niveau = niveau;
    }

    public Candidature getCandidature() {
        return candidature;
    }

    public void setCandidature(Candidature candidature) {
        this.candidature = candidature;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDuree_experience() {
        return duree_experience;
    }

    public void setDuree_experience(String duree_experience) {
        this.duree_experience = duree_experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getExperience_professionnelle() {
        return experience_professionnelle;
    }

    public void setExperience_professionnelle(String experience_professionnelle) {
        this.experience_professionnelle = experience_professionnelle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLm() {
        return lm;
    }

    public void setLm(String lm) {
        this.lm = lm;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }
 

    
    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }


}