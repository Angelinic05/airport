package com.campuslands.modules.flightconnection.adapter.in;


import java.util.Optional;
import java.util.Scanner;


import com.campuslands.modules.flightconnection.application.FlightconnectionService;
import com.campuslands.modules.flightconnection.domain.Flightconnection;

public class FlightconnectionConsoleAdapter {
    private FlightconnectionService flightconnectionService;

    public FlightconnectionConsoleAdapter(FlightconnectionService flightconnectionService){
        this.flightconnectionService = flightconnectionService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;
        while (flag) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el numero de connexión: ");
                    String createConnectionNumber = scanner.nextLine();
                    System.out.println("Ingrese el numero del Viaje: ");
                    int createIdTrip = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Lista de aviones disponibles: ");
                    Integer createIdPlane = flightconnectionService.avaliablePlanesForTrip();
                    createIdPlane = createIdPlane == -1 ? null : createIdPlane;

                    System.out.print("Ingrese el ID del aeropuerto: ");
                    int createIdAirport = scanner.nextInt();

                    Flightconnection flightconnection = new Flightconnection(createConnectionNumber, createIdTrip, createIdPlane, createIdAirport);
                    flightconnectionService.saveFlightconnection(flightconnection);
                    break;

                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Optional<Flightconnection> optionalUpdatedFlightconnection = flightconnectionService.findByIdFlightconnection(updateId);
                    optionalUpdatedFlightconnection.ifPresentOrElse(updatedFlightconnection -> {
                        int optSubMenu = -1;
                        String submenu = "¿Qué desea actualizar?\n1. connectionNumber\n2. idTrip\n3. idPlane\n4. idAirport\n0. Salir\n";
                
                        while (optSubMenu != 0) {
                            System.out.println(submenu);
                            optSubMenu = Integer.parseInt(scanner.nextLine());
                
                            switch (optSubMenu) {
                                case 1:
                                    System.out.print("Ingrese el numero numero de connexión: ");
                                    String connectionNumberupdate = scanner.nextLine();
                                    updatedFlightconnection.setConnectionNumber(connectionNumberupdate);
                                    break;
                                case 2:
                                    System.out.print("Ingrese el nuevo ID del viaje: ");
                                    int idTripUpdated = Integer.parseInt(scanner.nextLine());
                                    updatedFlightconnection.setIdTrip(idTripUpdated);
                                    break;
                                case 3:
                                    System.out.print("Ingrese el nuevo ID del avion: ");
                                    int idPlaneUpdated = Integer.parseInt(scanner.nextLine());
                                    updatedFlightconnection.setIdPlane(idPlaneUpdated);
                                    break;
                                case 4:
                                    System.out.print("Ingrese el nuevo ID del aeropuerto: ");
                                    int idAirportUpdated = Integer.parseInt(scanner.nextLine());
                                    updatedFlightconnection.setIdAirport(idAirportUpdated);
                                    break;
                            }
                        }
                        flightconnectionService.updateFlightconnection(updatedFlightconnection);
                    }, () -> System.out.println("No se encontró la conexion del vuelo con ID: " + updateId));
                    break;


                case 3:
                    System.out.print("Ingrese el Id de la conexión de vuelo a buscar: ");
                    int findId = scanner.nextInt();
                    Optional<Flightconnection> flightconnection1 = flightconnectionService.findByIdFlightconnection(findId);
                    flightconnection1.ifPresentOrElse( 
                        p -> System.out.println("ID:" + p.getId() + ", numero de connexión : " + p.getConnectionNumber() + ", idTrip: " + p.getIdTrip() + ", idPlane: " + p.getIdPlane() + ", idAirport: " + p.getIdAirport()), 
                        () -> System.out.println("Conexión de vuelo no encontrado")); 
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
                    System.out.println("Lista de Trayectos sin aeronave: ");
                    int idFlightconnection = flightconnectionService.avaliableFlightsForPlane();
                    if(idFlightconnection == -1){break;}
                    Flightconnection flightconnection2 = flightconnectionService.findByIdFlightconnection(idFlightconnection).get();
                    Integer idPlane = flightconnectionService.avaliablePlanesForTrip();
                    if(idPlane == -1){break;}
                    flightconnection2.setIdPlane(idPlane);
                    flightconnectionService.updateFlightconnection(flightconnection2);
                    
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    scanner.nextLine();
                    return;
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
        System.out.println("6. Asignar aeronave conexiónes de vuelo");
        System.out.println("0. Salir");
        System.out.println("");
        System.out.print("Ingrese la opcion: ");
        int choice = -1;

        while (choice < 0 || choice > 6) {
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
