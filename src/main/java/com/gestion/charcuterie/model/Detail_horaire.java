package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "detail_horaire")
public class Detail_horaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_horaire")
    private Horaire_travail horaireTravail;

    private LocalTime heure_debut;
    private LocalTime heure_fin;

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Horaire_travail getHoraireTravail() {
        return horaireTravail;
    }

    public void setHoraireTravail(Horaire_travail horaireTravail) {
        this.horaireTravail = horaireTravail;
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
