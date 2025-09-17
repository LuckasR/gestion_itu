package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Qcm_reponseService {
    List<Qcm_reponse> getAll();
    Qcm_reponse getById(Integer id);
    void save(Qcm_reponse obj);
    void delete(Integer id);
}