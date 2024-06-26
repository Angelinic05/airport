package com.campuslands.modules.flightconnection.application;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.employee.domain.Employee;
import com.campuslands.modules.flightconnection.domain.Flightconnection;
import com.campuslands.modules.flightconnection.infrastructure.FlightconnectionRepository;
import com.campuslands.modules.plane.domain.Plane;
import com.campuslands.modules.plane.infrastructure.PlaneRepository;

public class FlightconnectionService {
    private FlightconnectionRepository flightconnectionRepository;
    private PlaneRepository planeRepository;

    public FlightconnectionService (FlightconnectionRepository flightconnectionRepository){
        this.flightconnectionRepository = flightconnectionRepository;
    }
    public FlightconnectionService (FlightconnectionRepository flightconnectionRepository, PlaneRepository planeRepository) {
        this.flightconnectionRepository = flightconnectionRepository;
        this.planeRepository = planeRepository;
    }

    public void saveFlightconnection(Flightconnection flightconnection){
        flightconnectionRepository.save(flightconnection);
    }

    public void updateFlightconnection(Flightconnection flightconnection){
        flightconnectionRepository.update(flightconnection);
    }

    public Optional<Flightconnection> findByIdFlightconnection(int id){
        return  flightconnectionRepository.findById(id);
    }

    public void deleteFlightconnection(int id){
        flightconnectionRepository.delete(id);
    }

    public List<Flightconnection> findAllFlightconnection(){
        return flightconnectionRepository.findAll();
    }

    public int avaliableFlightsForTrip(){
        Scanner sc = new Scanner(System.in);
        List<Flightconnection> lista = flightconnectionRepository.avaliableFlightsForTrip();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + "- " + lista.get(i));
        }
        System.out.println("\n0 - Salir.");
        System.out.println("\nSeleccione el trayecto: ");
        while (true) {
            try {
                int opc = sc.nextInt() - 1;

                if (opc == -1) {
                    return -1;
                } 

                if (opc < 0 || opc >= lista.size()) {
                    System.out.println("Selección inválida. Por favor, ingrese un número entre 0 y " + (lista.size() - 1) + ".");
                }
                else {
                    Flightconnection flightconnection = lista.get(opc);
                    return flightconnection.getId();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();
            }
        }
    }
    public int avaliableFlightsForPlane(){
        Scanner sc = new Scanner(System.in);
        List<Flightconnection> lista = flightconnectionRepository.avaliableFlightsForPlane();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + "- " + lista.get(i));
        }
        System.out.println("\n0 - Salir.");
        System.out.println("\nSeleccione el trayecto: ");
        while (true) {
            try {
                int opc = sc.nextInt() - 1;

                if (opc == -1) {
                    return -1;
                } 

                if (opc < 0 || opc >= lista.size()) {
                    System.out.println("Selección inválida. Por favor, ingrese un número entre 0 y " + (lista.size() - 1) + ".");
                }
                else {
                    Flightconnection flightconnection = lista.get(opc);
                    return flightconnection.getId();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();
            }
        }
    }

    public int avaliablePlanesForTrip(){
        Scanner sc = new Scanner(System.in);
        List<Plane> lista = planeRepository.avaliabPlanesForFlight();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + "- " + lista.get(i));
        }
        System.out.println("\n0 - Salir.");
        System.out.println("\nSeleccione la aeronave: ");
        while (true) {
            try {
                int opc = sc.nextInt() - 1;

                if (opc == -1) {
                    return -1;
                } 

                if (opc < 0 || opc >= lista.size()) {
                    System.out.println("Selección inválida. Por favor, ingrese un número entre 0 y " + (lista.size() - 1) + ".");
                }
                else {
                    Plane plane = lista.get(opc);
                    return plane.getId();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();
            }
        }
    }
}
