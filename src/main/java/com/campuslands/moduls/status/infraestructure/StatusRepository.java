package com.campuslands.moduls.status.infraestructure;

import java.util.List;
import java.util.Optional;

import com.campuslands.moduls.status.domain.Status;

public interface StatusRepository {
    void save(Status status);
    void update(Status status);
    Optional<Status> findById(int id);
    void delete(int id);
    List<Status> findAll();
}
