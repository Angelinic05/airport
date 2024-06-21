package com.campuslands.modules.airportAirline.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.campuslands.modules.airportAirline.application.AirportAirlineService;
import com.campuslands.modules.airportAirline.domain.AirportAirline;
public class AirportAirlineConsoleAdapter {
    private AirportAirlineService airportAirlineService;

    public AirportAirlineConsoleAdapter(AirportAirlineService airportAirlineService) {
        this.airportAirlineService = airportAirlineService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int choice = menu(scanner);
            
            switch (choice) {
                case 1:
                    listAirlines(scanner);
                    break;
                case 2:
                    addAirportAirline(scanner);
                    break;
                case 3:
                    updateAirportAirline(scanner);
                    break;
                case 4:
                    deleteAirportAirline(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ingrese una opcion valida (1 - 5).");
            }
        }
    }

    private int menu(Scanner scanner) {
        System.out.println("Airport Airline Management");
        System.out.println("1. List Airlines");
        System.out.println("2. Add Airport-Airline");
        System.out.println("3. Update Airline-Airport");
        System.out.println("4. Delete Airport-Airline");
        System.out.println("5. Salir");
        System.out.println("");
        System.out.print("Ingrese la opcion: ");
        int choice = -1;
        while (choice < 1 || choice > 5) {
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

    private void listAirlines(Scanner scanner) {
        List<AirportAirline> airportAirlines = airportAirlineService.getAllAirportAirlines();
        System.out.println("Listado de Airport-Airline:");
        for (AirportAirline airportAirline : airportAirlines) {
            System.out.println(airportAirline);
        }
    }
    
    private void addAirportAirline(Scanner scanner) {
        System.out.println("Agregar Airport-Airline:");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Airline ID: ");
        int airlineId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Airport ID: ");
        int airportId = scanner.nextInt();
        scanner.nextLine();
        
        AirportAirline airportAirline = new AirportAirline(id, airlineId, airportId);
        airportAirlineService.createAirportAirline(airportAirline);
    }

    private void updateAirportAirline(Scanner scanner) {
        System.out.println("Actualizar Airport-Airline:");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Airline ID: ");
        int airlineId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Airport ID: ");
        int airportId = scanner.nextInt();
        scanner.nextLine();
        
        AirportAirline airportAirline = new AirportAirline(id, airlineId, airportId);
        airportAirlineService.updateAirportAirline(airportAirline);
    }

    private void deleteAirportAirline(Scanner scanner) {
        System.out.println("Borrar Airport-Airline:");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        airportAirlineService.deleteAirportAirline(id);
    }
}
