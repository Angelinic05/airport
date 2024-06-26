package com.campuslands.modules.flightconnection.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.flightconnection.domain.Flightconnection;

public interface FlightconnectionRepository {
    void save(Flightconnection flightconnection);
    void update(Flightconnection flightconnection);
    Optional<Flightconnection> findById(int id);
    void delete(int id);
    List<Flightconnection> findAll();
    List<Flightconnection> avaliableFlightsForTrip(); //LISTA DE VUELOS DISPONIBLES PARA LA TABLA TRIP 
    List<Flightconnection> avaliableFlightsForPlane(); //LISTA DE AVIONES DISPONIBLES PARA AVION
}


