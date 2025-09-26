package com.gestion.charcuterie.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
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

    @Column(name = "durre_entretient", nullable = false)
    private BigDecimal durre_entretient = BigDecimal.valueOf(30.0); // en minute
    

    @Column(name = "pourcentage_passed", nullable = false)
    private BigDecimal pourcentage_passed ; // en minute
    

     
    public BigDecimal getPourcentage_passed() {
        return pourcentage_passed;
    }
    public void setPourcentage_passed(BigDecimal pourcentage_passed) {
        this.pourcentage_passed = pourcentage_passed;
    }
    
    public BigDecimal getDurre_entretient() {
        return durre_entretient;
    }
    public void setDurre_entretient(BigDecimal durre_entretient) {
        this.durre_entretient = durre_entretient;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getNombre_qcm_test() { return nombre_qcm_test; }
    public void setNombre_qcm_test(Integer nombre_qcm_test) { this.nombre_qcm_test = nombre_qcm_test; }

    public LocalDateTime getDate_creation() { return date_creation; }
    public void setDate_creation(LocalDateTime date_creation) { this.date_creation = date_creation; }

}