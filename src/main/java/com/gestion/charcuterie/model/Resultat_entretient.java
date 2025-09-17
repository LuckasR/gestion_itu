package com.gestion.charcuterie.model;
import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "resultat_entretient")
public class Resultat_entretient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "candidature_id")
    private Candidature candidature;

    
    private BigDecimal pourcentage_satisfaction;

    
    private String date_resultat;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Candidature getCandidature() { return candidature; }
    public void setCandidature(Candidature candidature) { this.candidature = candidature; }

    public BigDecimal getPourcentage_satisfaction() { return pourcentage_satisfaction; }
    public void setPourcentage_satisfaction(BigDecimal pourcentage_satisfaction) { this.pourcentage_satisfaction = pourcentage_satisfaction; }

    public String getDate_resultat() { return date_resultat; }
    public void setDate_resultat(String date_resultat) { this.date_resultat = date_resultat; }

}