package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface Detail_candidatureService {
    List<Detail_candidature> getAll();
    Detail_candidature getById(Integer id);
    void save(Detail_candidature obj);
    void delete(Integer id);
}