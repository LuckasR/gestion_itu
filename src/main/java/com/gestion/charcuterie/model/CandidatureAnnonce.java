package com.gestion.charcuterie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "v_candidature_annonce")  // correspond au nom de la vue
public class CandidatureAnnonce {

    @Id
    private Integer idCandidature;

    private String candidat;
    private String annonce;
    private String statusTraitement;
    private String filiere;
    private String niveauEtude;
    private String dureeExperience;
    private String skills;
    private String motivation;
    private String experienceProfessionnelle;
    private String cv;
    private String lm;
    private String cin;
    private String residence;
    private String date_entretient;


    public String getDate_entretient() {
        return date_entretient;
    }

    public void setDate_entretient(String date_entretient) {
        this.date_entretient = date_entretient;
    }

    // Getters et Setters
    public Integer getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(Integer idCandidature) {
        this.idCandidature = idCandidature;
    }

    public String getCandidat() {
        return candidat;
    }

    public void setCandidat(String candidat) {
        this.candidat = candidat;
    }

    public String getAnnonce() {
        return annonce;
    }

    public void setAnnonce(String annonce) {
        this.annonce = annonce;
    }

    public String getStatusTraitement() {
        return statusTraitement;
    }

    public void setStatusTraitement(String statusTraitement) {
        this.statusTraitement = statusTraitement;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public String getDureeExperience() {
        return dureeExperience;
    }

    public void setDureeExperience(String dureeExperience) {
        this.dureeExperience = dureeExperience;
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

    public String getExperienceProfessionnelle() {
        return experienceProfessionnelle;
    }

    public void setExperienceProfessionnelle(String experienceProfessionnelle) {
        this.experienceProfessionnelle = experienceProfessionnelle;
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
}
