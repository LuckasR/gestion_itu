package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository repo;

    public List<Genre> getAll() { return repo.findAll(); }
    public Genre getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(Genre obj) { repo.save(obj); }
    public void delete(Integer id) { repo.deleteById(id); }
}