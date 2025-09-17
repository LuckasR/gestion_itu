package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface AnnonceService {
    List<Annonce> getAll();
    Annonce getById(Integer id);
    void save(Annonce obj);
    void delete(Integer id);
}