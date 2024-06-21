package com.campuslands.modules.manufacture.infrastructure;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.manufacture.domain.Manufacture;

public interface ManufactureRepository {
    void save(Manufacture status);
    void update(Manufacture status);
    Optional<Manufacture> findById(int id);
    void delete(int id);
    List<Manufacture> findAll();
    
}
