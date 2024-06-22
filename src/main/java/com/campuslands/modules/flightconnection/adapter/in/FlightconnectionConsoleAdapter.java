package com.campuslands.modules.flightconnection.adapter.in;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.employee.domain.Employee;
import com.campuslands.modules.flightconnection.application.FlightconnectionService;
import com.campuslands.modules.flightconnection.domain.Flightconnection;

public class FlightconnectionConsoleAdapter {
    private FlightconnectionService flightconnectionService;

    public FlightconnectionConsoleAdapter(FlightconnectionService flightconnectionService){
        this.flightconnectionService = flightconnectionService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:

                    System.out.print("Ingrese el numero de connexión: ");
                    String createConnectionNumber = scanner.nextLine();
                    scanner.nextLine();

                    System.out.print("Ingrese el ID del viaje: ");
                    int createIdTrip = scanner.nextInt();

                    System.out.print("Ingrese el ID del avion: ");
                    int createIdPlane = scanner.nextInt();

                    System.out.print("Ingrese el ID del aeropuerto: ");
                    int createIdAirport = scanner.nextInt();

                    Flightconnection flightconnection = new Flightconnection(createConnectionNumber, createIdTrip, createIdPlane, createIdAirport);
                    flightconnectionService.saveFlightconnection(flightconnection);
                    break;

                case 2:

                    System.out.print("Ingrese el ID de la conexión de vuelo a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el numero numero de connexión: ");
                    String updateConnectionNumber = scanner.nextLine();
                    scanner.nextLine();

                    System.out.print("Ingrese el nuevo ID del viaje: ");
                    int updateIdTrip = scanner.nextInt();

                    System.out.print("Ingrese el nuevo ID del avion: ");
                    int updateIdPlane = scanner.nextInt();

                    System.out.print("Ingrese el nuevo ID del aeropuerto: ");
                    int updateIdAirport = scanner.nextInt();

                    Flightconnection updateflightconnection = new Flightconnection(updateId, updateConnectionNumber, updateIdTrip, updateIdPlane, updateIdAirport);
                    flightconnectionService.updateFlightconnection(updateflightconnection);
                    break;

                case 3:
                    System.out.print("Ingrese el Id de la conexión de vuelo a buscar: ");
                    int findId = scanner.nextInt();
                    Optional<Flightconnection> flightconnection1 = flightconnectionService.findByIdFlightconnection(findId);
                    flightconnection1.ifPresentOrElse( 
                        p -> System.out.println("ID:" + p.getId() + ", numero de connexión : " + p.getConnectionNumber() + ", idTrip: " + p.getIdTrip() + ", idPlane: " + p.getIdPlane() + ", idAirport: " + p.getIdAirport()), 
                        () -> System.out.println("Conexión de vuelono encontrado")); 
                    break;

                case 4:
                    System.out.print("Ingrese el Id de la conexión de vuelo a borrar: ");
                    int deleteId = scanner.nextInt();
                    flightconnectionService.deleteFlightconnection(deleteId);
                    break;

                case 5:
                    flightconnectionService.findAllFlightconnection().forEach(p -> {
                        System.out.println("ID:" + p.getId() + ", numero de connexión : " + p.getConnectionNumber() + ", idTrip: " + p.getIdTrip() + ", idPlane: " + p.getIdPlane() + ", idAirport: " + p.getIdAirport());
                    });
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }

    private int menu(Scanner scanner){
        System.out.println("1. Crear una conexión de vuelo");
        System.out.println("2. Actualizar una conexión de vuelo");
        System.out.println("3. Buscar una conexión de vuelo por ID");
        System.out.println("4. Eliminar una conexión de vuelo");
        System.out.println("5. Listar todas las conexiónes de vuelo");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("Ingrese la opcion: ");
        int choice = -1;

        while (choice < 1 || choice > 6) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 6) {                    
                    System.out.println("Ingrese una opcion valida (1 - 6).");
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida (1 - 6).");
            }
        }
        return choice;
    }
    
    
    
}
