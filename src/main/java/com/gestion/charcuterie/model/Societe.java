package com.gestion.charcuterie.model;
import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "societe")
public class Societe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    private String name;

    
    private Integer nombre_qcm_test;

    
    private String date_creation;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getNombre_qcm_test() { return nombre_qcm_test; }
    public void setNombre_qcm_test(Integer nombre_qcm_test) { this.nombre_qcm_test = nombre_qcm_test; }

    public String getDate_creation() { return date_creation; }
    public void setDate_creation(String date_creation) { this.date_creation = date_creation; }

}