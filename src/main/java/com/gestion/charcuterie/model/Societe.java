package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "societe")
public class Societe {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "nombre_qcm_test", nullable = false)
    private Integer nombre_qcm_test = 1;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime date_creation = LocalDateTime.now();

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getNombre_qcm_test() { return nombre_qcm_test; }
    public void setNombre_qcm_test(Integer nombre_qcm_test) { this.nombre_qcm_test = nombre_qcm_test; }

    public LocalDateTime getDate_creation() { return date_creation; }
    public void setDate_creation(LocalDateTime date_creation) { this.date_creation = date_creation; }

}