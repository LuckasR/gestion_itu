package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "annonce")
public class Annonce {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Le titre est obligatoire")
    @Column(nullable = false)
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

    @NotBlank(message = "La description est obligatoire")
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "La date de publication est obligatoire")
    @Column(nullable = false)
    private LocalDate date_publication;

    @NotNull(message = "La date d'expiration est obligatoire")
    @Column(nullable = false)
    private LocalDate date_expiration;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Departement getDepartement() { return departement; }
    public void setDepartement(Departement departement) { this.departement = departement; }

    public Niveau_etude getNiveau_etude() { return niveau_etude; }
    public void setNiveau_etude(Niveau_etude niveau_etude) { this.niveau_etude = niveau_etude; }

    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }

    public Type_contrat getType_contrat() { return type_contrat; }
    public void setType_contrat(Type_contrat type_contrat) { this.type_contrat = type_contrat; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate_publication() { return date_publication; }
    public void setDate_publication(LocalDate date_publication) { this.date_publication = date_publication; }

    public LocalDate getDate_expiration() { return date_expiration; }
    public void setDate_expiration(LocalDate date_expiration) { this.date_expiration = date_expiration; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

}