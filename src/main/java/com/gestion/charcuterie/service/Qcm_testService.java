package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Qcm_testService {
    List<Qcm_test> getAll();
    Qcm_test getById(Integer id);
    void save(Qcm_test obj);
    void delete(Integer id);
}