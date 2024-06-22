package com.campuslands;

import java.util.Scanner;

import com.campuslands.modules.revision.adapter.in.RevisionConsoleAdapter;
import com.campuslands.modules.revision.adapter.out.RevisionMySQLRepository;
import com.campuslands.modules.revision.application.RevisionService;
import com.campuslands.modules.revision.domain.Revision;

import com.campuslands.modules.revisiondetail.adapter.in.RevisiondetailConsoleAdapter;
import com.campuslands.modules.revisiondetail.adapter.out.RevisiondetailMySQLRepository;
import com.campuslands.modules.revisiondetail.application.RevisiondetailService;
import com.campuslands.modules.revisiondetail.domain.Revisiondetail;


import com.campuslands.modules.status.adapter.in.StatusConsoleAdapter;
import com.campuslands.modules.status.adapter.out.StatusMySQLRepository;
import com.campuslands.modules.status.application.StatusService;
import com.campuslands.modules.status.domain.Status;

import com.campuslands.modules.trip.adapter.in.TripConsoleAdapter;
import com.campuslands.modules.trip.adapter.out.TripMySQLRepository;
import com.campuslands.modules.trip.application.TripService;
import com.campuslands.modules.trip.domain.Trip;

import com.campuslands.modules.tripbooking.adapter.in.TripbookingConsoleAdapter;
import com.campuslands.modules.tripbooking.adapter.out.TripbookingMySQLRepository;
import com.campuslands.modules.tripbooking.application.TripbookingService;
import com.campuslands.modules.tripbooking.domain.Tripbooking;

import com.campuslands.modules.tripbookingdetail.adapter.in.TripbookingdetailConsoleAdapter;
import com.campuslands.modules.tripbookingdetail.adapter.out.TripbookingdetailMySQLRepository;
import com.campuslands.modules.tripbookingdetail.application.TripbookingdetailService;
import com.campuslands.modules.tripbookingdetail.domain.Tripbookingdetail;

import com.campuslands.modules.tripcrew.adapter.in.TripcrewConsoleAdapter;
import com.campuslands.modules.tripcrew.adapter.out.TripcrewMySQLRepository;
import com.campuslands.modules.tripcrew.application.TripcrewService;
import com.campuslands.modules.tripcrew.domain.Tripcrew;

import com.campuslands.modules.tripulationrol.adapter.in.TripulationrolConsoleAdapter;
import com.campuslands.modules.tripulationrol.adapter.out.TripulationrolMySQLRepository;
import com.campuslands.modules.tripulationrol.application.TripulationrolService;
import com.campuslands.modules.tripulationrol.domain.Tripulationrol;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // String url = "jdbc:mysql://localhost:3306/airport";
        String url = "jdbc:mysql://javaairportdb.cfecucemoghu.us-east-2.rds.amazonaws.com:3306/airport";
        String username = "airportDB";
        String password = "AngeliKikeMichi";

        RevisionMySQLRepository revisionRepository = new RevisionMySQLRepository(url, username, password);
        RevisiondetailMySQLRepository revisiondetailRepository = new RevisiondetailMySQLRepository(url, username, password);
        StatusMySQLRepository statusRepository = new StatusMySQLRepository(url, username, password);
        TripMySQLRepository tripRepository = new TripMySQLRepository(url, username, password);
        TripbookingMySQLRepository tripbookingRepository = new TripbookingMySQLRepository(url, username, password);
        TripbookingdetailMySQLRepository tripbookingdetailRepository = new TripbookingdetailMySQLRepository(url, username, password);
        TripcrewMySQLRepository tripcrewRepository = new TripcrewMySQLRepository(url, username, password);
        TripulationrolMySQLRepository tripulationrolRepository = new TripulationrolMySQLRepository(url, username, password);

        System.out.println("--------------- MENU PRINCIPAL ---------------");
        while (true) {
            System.out.println("1. airline");
            System.out.println("2. airport");
            System.out.println("3. airportairline");
            System.out.println("4. city");
            System.out.println("5. country");
            System.out.println("6. customer");
            System.out.println("7. documenttype");
            System.out.println("8. employee");
            System.out.println("9. flightconnection");
            System.out.println("10. flightfare");
            System.out.println("11. gate");
            System.out.println("12. manufacture");
            System.out.println("13. model");
            System.out.println("14. plane");
            System.out.println("15. revemployee");
            System.out.println("16. revision");
            System.out.println("17. revisiondetail");
            System.out.println("18. status");
            System.out.println("19. trip");
            System.out.println("20. tripbooking");
            System.out.println("21. tripbookingdetail");
            System.out.println("22. tripcrew");
            System.out.println("23. tripulationrol");
            System.out.println("");
            System.out.print("Ingrese la opcion: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("airline");
                    break;
                case 2:
                    System.out.println("airport");
                    break;
                case 3:
                    System.out.println("airportairline");
                    break;
                case 4:
                    System.out.println("city");
                    break;
                case 5:
                    System.out.println("country");
                    break;
                case 6:
                    System.out.println("customer");
                    break;
                case 7:
                    System.out.println("documenttype");
                    break;
                case 8:
                    System.out.println("employee");
                    break;
                case 9:
                    System.out.println("flightconnection");
                    break;
                case 10:
                    System.out.println("flightfare");
                    break;
                case 11:
                    System.out.println("gate");
                    break;
                case 12:
                    System.out.println("manufacture");
                    break;
                case 13:
                    System.out.println("model");
                    break;
                case 14:
                    System.out.println("plane");
                    break;
                case 15:
                    System.out.println("revemployee");
                    break;
                case 16:
                    System.out.println("revision");
                    RevisionService revisionService = new RevisionService(revisionRepository);
                    RevisionConsoleAdapter revisionConsoleAdapter = new RevisionConsoleAdapter(revisionService);
                    revisionConsoleAdapter.start();
                    break;
                case 17:
                    System.out.println("revisiondetail");
                    RevisiondetailService revisiondetailService = new RevisiondetailService(revisiondetailRepository);
                    RevisiondetailConsoleAdapter revisiondetailConsoleAdapter = new RevisiondetailConsoleAdapter(revisiondetailService);
                    revisiondetailConsoleAdapter.start();
                    break;
                case 18:
                    System.out.println("status");
                    StatusService statusService = new StatusService(statusRepository);
                    StatusConsoleAdapter statusConsoleAdapter = new StatusConsoleAdapter(statusService);
                    statusConsoleAdapter.start();
                    break;
                case 19:
                    System.out.println("trip");
                    TripService tripService = new TripService(tripRepository);
                    TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
                    tripConsoleAdapter.start();
                    break;
                case 20:
                    System.out.println("tripbooking");
                    TripbookingService tripbookingService = new TripbookingService(tripbookingRepository);
                    TripbookingConsoleAdapter tripbookingConsoleAdapter = new TripbookingConsoleAdapter(tripbookingService);
                    tripbookingConsoleAdapter.start();
                    break;
                case 21:
                    System.out.println("tripboTripbooking");
                    TripbookingdetailService tripbookingdetailService = new TripbookingdetailService(tripbookingdetailRepository);
                    TripbookingdetailConsoleAdapter tripbookingdetailConsoleAdapter = new TripbookingdetailConsoleAdapter(tripbookingdetailService);
                    tripbookingdetailConsoleAdapter.start();
                    break;
                case 22:
                    System.out.println("tripcrew");
                    TripcrewService tripcrewService = new TripcrewService(tripcrewRepository);
                    TripcrewConsoleAdapter tripcrewConsoleAdapter = new TripcrewConsoleAdapter(tripcrewService);
                    tripcrewConsoleAdapter.start();
                    break;
                case 23:
                    System.out.println("tripulationrol");
                    TripulationrolService tripulationrolService = new TripulationrolService(tripulationrolRepository);
                    TripulationrolConsoleAdapter tripulationrolConsoleAdapter = new TripulationrolConsoleAdapter(tripulationrolService);
                    tripulationrolConsoleAdapter.start();
                    break;
                case 24:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");

        
                }
            }
    }
}

/*
 *  Crear una funcion para imprimir el menu y crear una funcion para majear el ingreso de los datos.
 * 
 */