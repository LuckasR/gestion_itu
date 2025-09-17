package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface GenreService {
    List<Genre> getAll();
    Genre getById(Integer id);
    void save(Genre obj);
    void delete(Integer id);
}