package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "information_employee")
public class Information_employee {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Type_contrat type_contrat;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "cv")
    private String cv;

    @Column(name = "lm")
    private String lm;

    @Column(name = "cin")
    private String cin;

    @Column(name = "residence")
    private String residence;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime date_creation = LocalDateTime.now();

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Type_contrat getType_contrat() { return type_contrat; }
    public void setType_contrat(Type_contrat type_contrat) { this.type_contrat = type_contrat; }

    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCv() { return cv; }
    public void setCv(String cv) { this.cv = cv; }

    public String getLm() { return lm; }
    public void setLm(String lm) { this.lm = lm; }

    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }

    public String getResidence() { return residence; }
    public void setResidence(String residence) { this.residence = residence; }

    public LocalDateTime getDate_creation() { return date_creation; }
    public void setDate_creation(LocalDateTime date_creation) { this.date_creation = date_creation; }

}