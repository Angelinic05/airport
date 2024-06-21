package com.campuslands.modules.tripcrew.adapter.in;

import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.tripcrew.application.TripcrewService;
import com.campuslands.modules.tripcrew.domain.Tripcrew;

public class TripcrewConsoleAdapter {
    private final TripcrewService tripcrewService;

    public TripcrewConsoleAdapter(TripcrewService tripcrewService) {
        this.tripcrewService = tripcrewService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del idEmployee: ");
                    int createIdEmployee = scanner.nextInt();

                    System.out.print("Ingrese el nombre del idConnection: ");
                    int createIdConnection = scanner.nextInt();

                    Tripcrew newTripcrew = new Tripcrew(createIdEmployee, createIdConnection);
                    tripcrewService.createTripcrew(newTripcrew);

                    break;
                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el nombre del idEmployee: ");
                    int updateIdEmployee = scanner.nextInt();

                    System.out.print("Ingrese el nombre del idConnection: ");
                    int updateIdConnection = scanner.nextInt();

                    Tripcrew updatedTripcrew = new Tripcrew(updateId, updateIdEmployee, updateIdConnection);
                    tripcrewService.updateTripcrew(updatedTripcrew);
                    break;

                case 3:
                    System.out.print("Ingrese el Id del status a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Tripcrew> tripcrew = tripcrewService.getTripcrewById(findId);
                        tripcrew.ifPresentOrElse(
                        p -> System.out.println("ID: " + p.getId() + ", IdEmployee: " + p.getIdEmployee() + ", IdConnection: " + p.getIdConnection()),
                        () -> System.out.println("Status no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id del status a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    tripcrewService.deleteTripcrew(deleteId);
                    break;

                case 5:
                    tripcrewService.getAllTripcrews().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", IdEmployee: " + p.getIdEmployee() + ", IdConnection: " + p.getIdConnection());
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
        System.out.println("1. Crear Status");
        System.out.println("2. Actualizar Status");
        System.out.println("3. Buscar Status por ID");
        System.out.println("4. Eliminar Status");
        System.out.println("5. Listar todos Statuses");
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
