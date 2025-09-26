package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "emploi_dt_entretient")
public class Emploi_dt_entretient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "planing_entretient_id")
    private Planing_entretient planingEntretient;

    private String tache_title;

    @Column(name = "date_entretient")
    private LocalDate dateEntretient;

    private LocalTime heure_debut;

    private LocalTime heure_fin;

    public Planing_entretient getPlaningEntretient() {
        return planingEntretient;
    }

    public void setPlaningEntretient(Planing_entretient planingEntretient) {
        this.planingEntretient = planingEntretient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTache_title() {
        return tache_title;
    }

    public void setTache_title(String tache_title) {
        this.tache_title = tache_title;
    }

    public LocalDate getDateEntretient() {
        return dateEntretient;
    }

    public void setDateEntretient(LocalDate dateEntretient) {
        this.dateEntretient = dateEntretient;
    }

    public LocalTime getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(LocalTime heure_debut) {
        this.heure_debut = heure_debut;
    }

    public LocalTime getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(LocalTime heure_fin) {
        this.heure_fin = heure_fin;
    }

}