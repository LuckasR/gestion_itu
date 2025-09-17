package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Qcm_questionService {
    List<Qcm_question> getAll();
    Qcm_question getById(Integer id);
    void save(Qcm_question obj);
    void delete(Integer id);
}