package com.gestion.charcuterie.model;
import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "planing_entretient")
public class Planing_entretient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    
    private String date_entretient;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Candidature getCandidature() { return candidature; }
    public void setCandidature(Candidature candidature) { this.candidature = candidature; }

    public Siege_entreprise getSiege_entreprise() { return siege_entreprise; }
    public void setSiege_entreprise(Siege_entreprise siege_entreprise) { this.siege_entreprise = siege_entreprise; }

    public String getDate_entretient() { return date_entretient; }
    public void setDate_entretient(String date_entretient) { this.date_entretient = date_entretient; }

}