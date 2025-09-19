package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "contrat_employee")
public class Contrat_employee {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Type_contrat type_contrat;

    @NotNull(message = "La date de début du contrat est obligatoire")
    @Column(name = "date_debut_contrat", nullable = false)
    private LocalDateTime date_debut_contrat = LocalDateTime.now();

    @NotNull(message = "La date de fin du contrat est obligatoire")
    @Column(name = "date_fin_contrat", nullable = false)
    private LocalDateTime date_fin_contrat;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Type_contrat getType_contrat() { return type_contrat; }
    public void setType_contrat(Type_contrat type_contrat) { this.type_contrat = type_contrat; }

    public LocalDateTime getDate_debut_contrat() { return date_debut_contrat; }
    public void setDate_debut_contrat(LocalDateTime date_debut_contrat) { this.date_debut_contrat = date_debut_contrat; }

    public LocalDateTime getDate_fin_contrat() { return date_fin_contrat; }
    public void setDate_fin_contrat(LocalDateTime date_fin_contrat) { this.date_fin_contrat = date_fin_contrat; }

}