package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "resultat_entretient")
public class Resultat_entretient {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "candidature_id")
    private Candidature candidature;

    @Column(name = "pourcentage_satisfaction", precision = 10, scale = 2)
    private BigDecimal pourcentage_satisfaction;

    @Column(name = "date_resultat")
    private LocalDateTime date_resultat = LocalDateTime.now();

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Candidature getCandidature() { return candidature; }
    public void setCandidature(Candidature candidature) { this.candidature = candidature; }

    public BigDecimal getPourcentage_satisfaction() { return pourcentage_satisfaction; }
    public void setPourcentage_satisfaction(BigDecimal pourcentage_satisfaction) { this.pourcentage_satisfaction = pourcentage_satisfaction; }

    public LocalDateTime getDate_resultat() { return date_resultat; }
    public void setDate_resultat(LocalDateTime date_resultat) { this.date_resultat = date_resultat; }

}