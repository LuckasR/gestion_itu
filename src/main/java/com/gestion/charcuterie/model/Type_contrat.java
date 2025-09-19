package com.gestion.charcuterie.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "type_contrat")
public class Type_contrat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    private String name;

    
    private BigDecimal durre_contrat;

    
    private Integer recurrence_renouvelement;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getDurre_contrat() { return durre_contrat; }
    public void setDurre_contrat(BigDecimal durre_contrat) { this.durre_contrat = durre_contrat; }

    public Integer getRecurrence_renouvelement() { return recurrence_renouvelement; }
    public void setRecurrence_renouvelement(Integer recurrence_renouvelement) { this.recurrence_renouvelement = recurrence_renouvelement; }

}