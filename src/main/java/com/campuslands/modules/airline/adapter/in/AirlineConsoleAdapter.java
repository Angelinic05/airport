package com.campuslands.modules.airline.adapter.in;

import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.airline.application.AirlineService;
import com.campuslands.modules.airline.domain.Airline;

public class AirlineConsoleAdapter {
    
    private AirlineService airlineService;

    public AirlineConsoleAdapter(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:

                    System.out.print("Ingrese el nombre de la aerolinea: ");
                    String name = scanner.nextLine();
                    Airline newAirline = new Airline(name);
                    airlineService.createAirline(newAirline);

                    break;
                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el nombre de la aerolinea: ");
                    String nombre = scanner.nextLine();

                    Airline updatedAirline = new Airline(updateId, nombre);

                    airlineService.updateAirline(updatedAirline);
                    break;

                case 3:
                    System.out.print("Ingrese el Id de la aerolinea a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Airline> status = airlineService.getAirlineById(findId);
                        status.ifPresentOrElse(
                        p -> System.out.println(p),
                        () -> System.out.println("Aerolinea no encontrado")
                    );

                    break;

                case 4:
                    System.out.print("Ingrese el Id de la aerolinea a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    airlineService.deleteAirline(deleteId);
                    break;

                case 5:
                    airlineService.getAllAirlines().forEach(p -> {
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
        System.out.println("1. Crear Aerolinea");
        System.out.println("2. Actualizar Aerolinea");
        System.out.println("3. Buscar Aerolinea por ID");
        System.out.println("4. Eliminar Aerolinea");
        System.out.println("5. Listar todos Aerolineas");
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
