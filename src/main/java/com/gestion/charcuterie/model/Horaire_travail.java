package com.gestion.charcuterie.model;
import jakarta.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "horaire_travail")
public class Horaire_travail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
   @Column(name = "jour_semaine")
    private String jourSemaine;

    public String getJourSemaine() {
    return jourSemaine;
}
   public void setJourSemaine(String jourSemaine) {
    this.jourSemaine = jourSemaine;
   }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
 
}