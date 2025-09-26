package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Signature_contratService {
    List<Signature_contrat> getAll();
    Signature_contrat getById(Integer id);
    void save(Signature_contrat obj);
    void delete(Integer id);
    List<Signature_contrat>  getByCandidat(Candidature candidat) ; 
}