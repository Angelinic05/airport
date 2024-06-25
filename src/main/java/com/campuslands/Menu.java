package com.campuslands;

import java.util.Scanner;

import com.campuslands.modules.airport.adapter.in.AirportConsoleAdapter;
import com.campuslands.modules.airport.adapter.out.AirportMySQLRepository;
import com.campuslands.modules.airport.application.AirportService;
import com.campuslands.modules.customer.adapter.in.CustomerConsoleAdapter;
import com.campuslands.modules.customer.adapter.out.CustomerMySQLRepository;
import com.campuslands.modules.customer.application.CustomerService;
import com.campuslands.modules.documenttype.adapter.in.DocumenttypeConsoleAdapter;
import com.campuslands.modules.documenttype.adapter.out.DocumenttypeMySQLRepository;
import com.campuslands.modules.documenttype.application.DocumenttypeService;
import com.campuslands.modules.flightconnection.adapter.in.FlightconnectionConsoleAdapter;
import com.campuslands.modules.flightconnection.adapter.out.FlightconnectionMySQLRepository;
import com.campuslands.modules.flightconnection.application.FlightconnectionService;
import com.campuslands.modules.flightfare.adapter.in.FlightfareConsoleAdapter;
import com.campuslands.modules.flightfare.adapter.out.FlightfareMySQLRepository;
import com.campuslands.modules.flightfare.application.FlightfareService;
import com.campuslands.modules.plane.adapter.in.PlaneConsoleAdapter;
import com.campuslands.modules.plane.adapter.out.PlaneMySQLRepository;
import com.campuslands.modules.plane.application.PlaneService;
import com.campuslands.modules.revision.adapter.in.RevisionConsoleAdapter;
import com.campuslands.modules.revision.adapter.out.RevisionMySQLRepository;
import com.campuslands.modules.revision.application.RevisionService;
import com.campuslands.modules.trip.adapter.in.TripConsoleAdapter;
import com.campuslands.modules.trip.adapter.out.TripMySQLRepository;
import com.campuslands.modules.trip.application.TripService;
import com.campuslands.modules.tripbooking.adapter.in.TripbookingConsoleAdapter;
import com.campuslands.modules.tripbooking.adapter.out.TripbookingMySQLRepository;
import com.campuslands.modules.tripbooking.application.TripbookingService;
import com.campuslands.modules.tripcrew.adapter.in.TripcrewConsoleAdapter;
import com.campuslands.modules.tripcrew.adapter.out.TripcrewMySQLRepository;
import com.campuslands.modules.tripcrew.application.TripcrewService;

public class Menu {
    public static void main(String[] args) {
        System.out.println("hola");
        Scanner sc = new Scanner(System.in);

        menu(sc);
    }

    public static void menu(Scanner sc){

        String url = "jdbc:mysql://javaairportdb.cfecucemoghu.us-east-2.rds.amazonaws.com:3306/airport";
        String username = "airportDB";
        String password = "AngeliKikeMichi";

        int choice;
        while(true){
            System.out.println("Bienvenido a Airport MichKiAn \3");
            System.out.println("Seleccione el usuario al que desea ingresar: \n \4 1. Administrador del Sistema \n \4 2. Agente de Ventas \n \4 3. Tecnico de Mantenimiento \n \4 4. Cliente \n \4 5. Salir");
            switch (choice = Integer.parseInt(sc.nextLine())) {
                case 1:
                    opcionesAdministrador(sc, url, username, password);                    
                    break;
                case 2:
                    opcionesAgentedeVentas(sc, url, username, password);
                    break;
                case 3:
                    opcionesTecnicodeMantenimiento(sc, url, username, password);
                    break;
                case 4:
                    opcionesCliente(sc, url, username, password);
                    break;

                case 5:
                    System.out.println("Bye \3");
                    return;

                default:
                    break;
            }

        }
    
    }

    public static void opcionesAdministrador(Scanner sc, String url, String username, String password){
        boolean n = true;
        int choice;
        while(n){
            RevisionMySQLRepository revisionRepository = new RevisionMySQLRepository(url, username, password);
            TripMySQLRepository tripRepository = new TripMySQLRepository(url, username, password);
            System.out.println("Ahora se encuentra en el usuario de ADMINISTRADOR \5");
            System.out.println("Digite la opcion a la que desea ingresar: \n \6 1. Aviónes " + 
            "\n \6 2. Trayectos \n \6 3. Aeropuertos \n \6 4. Escalas \n \6 5. Tarifas de vuelo" +
            "\n \6 6. Tipos de Documentos \n \6 7. Revisiones \n \6 8. Salir");
            switch (choice = Integer.parseInt(sc.nextLine())) {
                case 1:

                    System.out.println("Avión");
                    PlaneMySQLRepository planeMySQLRepository = new PlaneMySQLRepository(url, username, password);
                    PlaneService planeService = new PlaneService(planeMySQLRepository);
                    PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planeService);
                    planeConsoleAdapter.start();
                    break;
                case 2:
                    System.out.println("Trayecto");
                    TripService tripService = new TripService(tripRepository);
                    TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
                    tripConsoleAdapter.start();
                    break;
                case 3:
                    System.out.println("Aeropuerto");
                    AirportMySQLRepository airportMySQLRepository = new AirportMySQLRepository(url, username, password);
                    AirportService airportService = new AirportService(airportMySQLRepository);
                    AirportConsoleAdapter airportConsoleAdapter = new AirportConsoleAdapter(airportService);
                    airportConsoleAdapter.start();
                    break;

                case 4:
                    System.out.println("Escalas");
                    FlightconnectionMySQLRepository flightconnectionMySQLRepository = new FlightconnectionMySQLRepository(url, username, password);
                    FlightconnectionService flightconnectionService = new FlightconnectionService(flightconnectionMySQLRepository);
                    FlightconnectionConsoleAdapter flightconnectionConsoleAdapter = new FlightconnectionConsoleAdapter(flightconnectionService);
                    flightconnectionConsoleAdapter.start();
                    break;

                case 5:
                    System.out.println("Tarifa de vuelo");
                    FlightfareMySQLRepository flightfareMySQLRepository = new FlightfareMySQLRepository(url, username, password);
                    FlightfareService flightfareService = new FlightfareService(flightfareMySQLRepository);
                    FlightfareConsoleAdapter flightfareConsoleAdapter = new FlightfareConsoleAdapter(flightfareService);
                    flightfareConsoleAdapter.start();
                    break;

                case 6:
                    System.out.println("Tipo de Documento");
                    DocumenttypeMySQLRepository documenttypeMySQLRepository = new DocumenttypeMySQLRepository(url, username, password);
                    DocumenttypeService documenttypeService = new DocumenttypeService(documenttypeMySQLRepository);
                    DocumenttypeConsoleAdapter documenttypeConsoleAdapter = new DocumenttypeConsoleAdapter(documenttypeService);
                    documenttypeConsoleAdapter.start();

                case 7:
                    System.out.println("revision");
                    RevisionService revisionService = new RevisionService(revisionRepository);
                    RevisionConsoleAdapter revisionConsoleAdapter = new RevisionConsoleAdapter(revisionService);
                    revisionConsoleAdapter.start();

                case 8:
                    System.out.println("Bye \3");
                    n = false;
                    break;
                default:
                    break;
            }

        }
        
    }

    public static void opcionesAgentedeVentas(Scanner sc, String url, String username, String password){
        int choice;
        boolean n = true;
        while(n){
            TripbookingMySQLRepository tripbookingRepository = new TripbookingMySQLRepository(url, username, password);
            TripcrewMySQLRepository tripcrewRepository = new TripcrewMySQLRepository(url, username, password);
            System.out.println("Ahora se encuentra en el usuario de AGENTE DE VENTAS \2");
            System.out.println("Digite la opcion a la que desea ingresar: \n \6 1. Vuelos " + 
            "\n \6 2. Clientes \n \6 3. Asignaciones de Tripulación \n \6 4. Tipos de Documento \n \6 5. Salir");
            switch (choice = Integer.parseInt(sc.nextLine())) {
                case 1:

                    System.out.println("Vuelos");
                    TripbookingService tripbookingService = new TripbookingService(tripbookingRepository);
                    TripbookingConsoleAdapter tripbookingConsoleAdapter = new TripbookingConsoleAdapter(tripbookingService);
                    tripbookingConsoleAdapter.start();
                    break;
                case 2:
                    System.out.println("Clientes");
                    CustomerMySQLRepository customerMySQLRepository = new CustomerMySQLRepository(url, username, password);
                    CustomerService customerService = new CustomerService(customerMySQLRepository);
                    CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);
                    customerConsoleAdapter.start();
                    break;
                case 3:
                    System.out.println("Asignaciones de Tripulación");
                    TripcrewService tripcrewService = new TripcrewService(tripcrewRepository);
                    TripcrewConsoleAdapter tripcrewConsoleAdapter = new TripcrewConsoleAdapter(tripcrewService);
                    tripcrewConsoleAdapter.start();
                    break;

                case 4:
                    System.out.println("Tipos de Documento");
                    DocumenttypeMySQLRepository documenttypeMySQLRepository = new DocumenttypeMySQLRepository(url, username, password);
                    DocumenttypeService documenttypeService = new DocumenttypeService(documenttypeMySQLRepository);
                    DocumenttypeConsoleAdapter documenttypeConsoleAdapter = new DocumenttypeConsoleAdapter(documenttypeService);
                    documenttypeConsoleAdapter.start();
                    break;
                case 5:
                    System.out.println("Bye \3");
                    n = false;
                    break;
                default:
                    break;
            }

        }
        
    }

    public static void opcionesTecnicodeMantenimiento(Scanner sc, String url, String username, String password){
        boolean n = true;
        int choice;
        while(n){
            RevisionMySQLRepository revisionRepository = new RevisionMySQLRepository(url, username, password);
            System.out.println("Ahora se encuentra en el usuario de TECNICO DE MANTENIMIENTO \1");
            System.out.println("Digite la opcion a la que desea ingresar: \n \6 1. Revisiones" + 
            "\n \6 2. Salir");
            switch (choice = Integer.parseInt(sc.nextLine())) {
                case 1:

                    System.out.println("Revision");
                    RevisionService revisionService = new RevisionService(revisionRepository);
                    RevisionConsoleAdapter revisionConsoleAdapter = new RevisionConsoleAdapter(revisionService);
                    revisionConsoleAdapter.start();
                    break;
                case 2:
                    System.out.println("Bye \n");
                    n = false;
                    break;
                default:
                    break;
            }

        }
        
    }

    public static void opcionesCliente(Scanner sc, String url, String username, String password){
        int choice;
        boolean n = true;
        while(n){
            TripbookingMySQLRepository tripbookingRepository = new TripbookingMySQLRepository(url, username, password);
            System.out.println("Ahora se encuentra en el usuario de CLIENTE \3");
            System.out.println("Digite la opcion a la que desea ingresar: \n \6 1. Vuelos " + 
            "\n \6 2. Salir");
            switch (choice = Integer.parseInt(sc.nextLine())) {
                case 1:
                    System.out.println("Vuelos");
                    TripbookingService tripbookingService = new TripbookingService(tripbookingRepository);
                    TripbookingConsoleAdapter tripbookingConsoleAdapter = new TripbookingConsoleAdapter(tripbookingService);
                    tripbookingConsoleAdapter.start();
                    break;
                case 2:
                    System.out.println("Bye \3");
                    n = false;
                    break;
                default:
                    break;
            }

        }
        
    }


    

   



    
}
