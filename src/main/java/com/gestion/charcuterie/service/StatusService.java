package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import java.util.List;

public interface StatusService {
    List<Status> getAll();
    Status getById(Integer id);
    void save(Status obj);
    void delete(Integer id);
}