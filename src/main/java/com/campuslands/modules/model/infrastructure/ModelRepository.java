package com.campuslands.modules.model.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.model.domain.Model;

public interface ModelRepository {
    void save(Model status);
    void update(Model status);
    Optional<Model> findById(int id);
    void delete(int id);
    List<Model> findAll();
    
}
