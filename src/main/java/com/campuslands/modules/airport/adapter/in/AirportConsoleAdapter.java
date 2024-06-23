package com.campuslands.modules.airport.adapter.in;

import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.airport.application.AirportService;
import com.campuslands.modules.airport.domain.Airport;

public class AirportConsoleAdapter {
    
    private AirportService airportService;
    
    public AirportConsoleAdapter(AirportService airportService) {
        this.airportService = airportService;
    }
    public void start() {

        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;
        while (flag) {
            int choice = menu(scanner);
            String name;
            Double xPosition;
            Double yPosition;
            int idCity;
            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del aeropuerto: ");
                    name = scanner.nextLine();
                    System.out.print("Ingrese el id de la ciudad: ");
                    idCity =Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese la coordenada x del aeropuerto: ");
                    xPosition = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ingrese la coordenada y del aeropuerto: ");
                    yPosition = Double.parseDouble(scanner.nextLine());

                    Airport newAirport = new Airport(name, idCity, xPosition, yPosition);
                    airportService.saveAirport(newAirport);

                    break;
                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Optional<Airport> optionalUpdatedAirport = airportService.findAirportById(updateId);
                    optionalUpdatedAirport.ifPresentOrElse(updatedAirport -> {
                        int optSubMenu = -1;
                        String submenu = "¿Qué desea actualizar?\n1. name\n2. idCity\n3. xPosition\n4. yPosition\n0. Salir\n";
                
                        while (optSubMenu != 0) {
                            System.out.println(submenu);
                            optSubMenu = Integer.parseInt(scanner.nextLine());
                
                            switch (optSubMenu) {
                                case 1:
                                    System.out.print("Ingrese el nuevo nombre: ");
                                    updatedAirport.setName(scanner.nextLine());
                                    break;
                                case 2:
                                    System.out.print("Ingrese el nuevo id de la ciudad: ");
                                    int idCityUpdated = Integer.parseInt(scanner.nextLine());
                                    updatedAirport.setIdCity(idCityUpdated);
                                    break;
                                case 3:
                                    System.out.print("Ingrese la nueva coordenada x: ");
                                    Double xPositionUpdated = Double.parseDouble(scanner.nextLine());
                                    updatedAirport.setxPosition(xPositionUpdated);
                                    break;
                                case 4:
                                    System.out.print("Ingrese la nueva coordenada y: ");
                                    Double yPositionUpdated = Double.parseDouble(scanner.nextLine());
                                    updatedAirport.setyPosition(yPositionUpdated);
                                    break;
                            }
                        }
                        airportService.updateAirport(updatedAirport);
                    }, () -> System.out.println("No se encontró el aeropuerto con ID: " + updateId));
                    break;

                case 3:
                    System.out.print("Ingrese el Id del aeropuerto a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Airport> status = airportService.findAirportById(findId);
                        status.ifPresentOrElse(
                        p -> System.out.println(p),
                        () -> System.out.println("Aeropuerto no encontrado")
                    );

                    break;

                case 4:
                    System.out.print("Ingrese el Id del Aeropuerto a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    airportService.deleteAirport(deleteId);
                    break;

                case 5:
                    airportService.findAllAirports().forEach(p -> {
                        System.out.println(p);
                    });
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
        System.out.println("1. Crear Aeropuerto");
        System.out.println("2. Actualizar Aeropuerto");
        System.out.println("3. Buscar Aeropuerto por ID");
        System.out.println("4. Eliminar Aeropuerto");
        System.out.println("5. Listar todos los Aeropuertos");
        System.out.println("0. Salir");
        System.out.println("");
        System.out.print("Ingrese la opcion: ");
        int choice = -1;
        while (choice < 0 || choice > 6) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 6) {                    
                    System.out.println("Ingrese una opcion valida (1 - 5).");
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida (1 - 5).");
            }
        }
        return choice;
    }
}
