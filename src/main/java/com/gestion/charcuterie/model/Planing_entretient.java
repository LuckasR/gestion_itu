package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "planing_entretient")
public class Planing_entretient {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "candidature_id")
    private Candidature candidature;

    @ManyToOne
    @JoinColumn(name = "siege_entreprise_id")
    private Siege_entreprise siege_entreprise;

    
    private LocalDateTime date_entretient;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Candidature getCandidature() { return candidature; }
    public void setCandidature(Candidature candidature) { this.candidature = candidature; }

    public Siege_entreprise getSiege_entreprise() { return siege_entreprise; }
    public void setSiege_entreprise(Siege_entreprise siege_entreprise) { this.siege_entreprise = siege_entreprise; }

    public LocalDateTime getDate_entretient() { return date_entretient; }
    public void setDate_entretient(LocalDateTime date_entretient) { this.date_entretient = date_entretient; }

}