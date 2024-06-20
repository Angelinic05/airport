package com.campuslands.modules.gate.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.gate.domain.Gate;


public interface GateRepository {
    void save(Gate status);
    void update(Gate status);
    Optional<Gate> findById(int id);
    void delete(int id);
    List<Gate> findAll();
}
