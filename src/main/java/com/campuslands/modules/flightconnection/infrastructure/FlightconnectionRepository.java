package com.campuslands.modules.flightconnection.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.employee.domain.Employee;
import com.campuslands.modules.flightconnection.domain.Flightconnection;

public interface FlightconnectionRepository {
    void save(Flightconnection flightconnection);
    void update(Flightconnection flightconnection);
    Optional<Flightconnection> findById(int id);
    void delete(int id);
    List<Flightconnection> findAll();
    
}
