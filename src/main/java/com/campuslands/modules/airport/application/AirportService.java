package com.campuslands.modules.airport.application;

import com.campuslands.modules.airport.infrastructure.AirportRepository;
import com.campuslands.modules.flightconnection.application.FlightconnectionService;
import com.campuslands.modules.flightconnection.domain.Flightconnection;
import com.campuslands.modules.flightconnection.infrastructure.FlightconnectionRepository;
import com.campuslands.modules.trip.domain.Trip;
import com.campuslands.modules.trip.infraestructure.TripRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.campuslands.modules.airport.domain.Airport;
import com.campuslands.modules.airport.infrastructure.AirportRepository;
import com.campuslands.modules.airport.domain.Graph;

public class AirportService {

    private AirportRepository airportRepository;
    private TripRepository tripRepository;
    private FlightconnectionRepository flightconnectionRepository;
    private Graph graph;

    public AirportService(AirportRepository airportRepository, TripRepository tripRepository, FlightconnectionRepository flightconnectionRepository) {
        this.airportRepository = airportRepository;
        this.tripRepository = tripRepository;
        this.flightconnectionRepository = flightconnectionRepository;
        this.graph = new Graph();
        initializeGraph();
    }

    private void initializeGraph() {
        HashMap<Integer, List<Integer>> airports = airportRepository.getAirportsByAirline();
        for (Map.Entry<Integer,List<Integer>> airlineAirport : airports.entrySet()) {
            List<Airport> airportsInAirline = new ArrayList<>();
            for (Integer idAirport : airlineAirport.getValue()) {
                Optional<Airport> airport = airportRepository.findById(idAirport);
                airportsInAirline.add(airport.get());
                System.out.println("Añadido aeropuerto al grafo: " + airport.get());
            }
            graph.addEdgeToAirports(airportsInAirline);
        }
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

    public List<Airport> findShortestPath(int startId, int endId) {
        return graph.findShortestPath(startId, endId);
    }

    public Graph getGraph() {
        return graph;
    }

    public String getAirportNameById(int airportId) {
        Optional<Airport> airport = airportRepository.findById(airportId);
        return airport.isPresent() ? airport.get().getName() : "Nombre no encontrado";
    }

    public HashMap<Integer, List<Integer>> getAirportsByAirline() {
        return airportRepository.getAirportsByAirline();
    }

    public int saveTrip(Trip trip){
        return tripRepository.saveAndReturnId(trip);
    }

    public void saveFlightConnection(Flightconnection flightconnection){
        flightconnectionRepository.save(flightconnection);
    }
}