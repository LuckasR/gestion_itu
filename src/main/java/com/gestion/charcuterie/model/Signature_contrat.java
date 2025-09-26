package com.gestion.charcuterie.model;

import jakarta.persistence.*;

@Entity
@Table(name = "signature_contrat")
public class Signature_contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidature_id")
    private Candidature candidat;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status_traitement status;

    public Status_traitement getStatus() {
        return status;
    }

    public void setStatus(Status_traitement status) {
        this.status = status;
    }

    public Candidature getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidature candidat) {
        this.candidat = candidat;
    }

}