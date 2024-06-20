package com.campuslands.modules.airportAirline.application;


import java.util.List;
import com.campuslands.modules.airportAirline.domain.AirportAirline;
import com.campuslands.modules.airportAirline.infrastructure.AirportAirlineRepository;

public class AirportAirlineService {
    private AirportAirlineRepository airportAirlineRepository;

    public AirportAirlineService(AirportAirlineRepository airportAirlineRepository) {
        this.airportAirlineRepository = airportAirlineRepository;
    }

    public void createAirportAirline(AirportAirline airportAirline) {
        airportAirlineRepository.save(airportAirline);
    }

    public void updateAirportAirline(AirportAirline airportAirline) {
        airportAirlineRepository.update(airportAirline);
    }

    public void deleteAirportAirline(int id) {
        airportAirlineRepository.delete(id);
    }

    public AirportAirline getAirportAirlineById(int id) {
        return airportAirlineRepository.findById(id).orElse(null);
    }
    public List<AirportAirline> getAllAirportAirlines() {
        return airportAirlineRepository.findAll();
    }
}
