package com.campuslands.modules.plane.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.plane.domain.Plane;

public interface PlaneRepository {
    void save(Plane status);
    void update(Plane status);
    Optional<Plane> findById(int id);
    void delete(int id);
    List<Plane> findAll();
    
}
