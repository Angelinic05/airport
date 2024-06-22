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

        while (true) {
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
                    Airport updatedAirport = airportService.findAirportById(updateId).orElse(null);
                    scanner.nextLine();

                    int optSubMenu = -1;
                    String submen = "Que desea actualizar\n1.name\n2.idCity\n3.xPosition\n4.yPosition\n0. Salir";
                    
                    while (optSubMenu != 0) {
                        System.out.println(submen);
                        optSubMenu = Integer.parseInt(submen);
                        switch (optSubMenu) {
                            case 1:
                                System.out.print("Ingrese el nuevo nombr: ");
                                updatedAirport.setName(scanner.nextLine());
                                break;
                            case 2:
                                System.out.print("Ingrese el nuevo id de la ciudad: ");
                                idCity = Integer.parseInt(scanner.nextLine());
                                updatedAirport.setIdCity(idCity);
                                break;
                            case 3:
                                System.out.print("Ingrese la nueva coordenada x: ");
                                xPosition = Double.parseDouble(scanner.nextLine());
                                updatedAirport.setxPosition(xPosition);
                                break;
                            case 4:
                                System.out.print("Ingrese la nueva coordenada y: ");
                                yPosition = Double.parseDouble(scanner.nextLine());
                                updatedAirport.setyPosition(yPosition);
                                break;
                        }
                    }
                    airportService.updateAirport(updatedAirport);
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
        System.out.println("1. Crear Aeropuerto");
        System.out.println("2. Actualizar Aeropuerto");
        System.out.println("3. Buscar Aeropuerto por ID");
        System.out.println("4. Eliminar Aeropuerto");
        System.out.println("5. Listar todos los Aeropuertos");
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
