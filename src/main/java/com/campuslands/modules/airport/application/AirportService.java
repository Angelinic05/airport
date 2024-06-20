package com.campuslands.modules.airport.application;

import com.campuslands.modules.airport.infrastructure.AirportRepository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.airport.domain.Airport;

public class AirportService {

    private AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void saveAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public void updateAirport(Airport airport) {
        airportRepository.update(airport);
    }

    public Optional<Airport> findAirportById(int id) {
        return airportRepository.findById(id);
    }

    public void deleteAirport(int id) {
        airportRepository.delete(id);
    }

    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }
    
    

}
