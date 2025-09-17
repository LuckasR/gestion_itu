package com.gestion.charcuterie.model;
import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "contrat_employee")
public class Contrat_employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    
    private String date_debut_contrat;

    
    private String date_fin_contrat;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Type_contrat getType_contrat() { return type_contrat; }
    public void setType_contrat(Type_contrat type_contrat) { this.type_contrat = type_contrat; }

    public String getDate_debut_contrat() { return date_debut_contrat; }
    public void setDate_debut_contrat(String date_debut_contrat) { this.date_debut_contrat = date_debut_contrat; }

    public String getDate_fin_contrat() { return date_fin_contrat; }
    public void setDate_fin_contrat(String date_fin_contrat) { this.date_fin_contrat = date_fin_contrat; }

}