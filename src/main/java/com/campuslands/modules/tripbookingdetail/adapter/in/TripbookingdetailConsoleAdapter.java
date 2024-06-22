package com.campuslands.modules.tripbookingdetail.adapter.in;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.tripbookingdetail.application.TripbookingdetailService;
import com.campuslands.modules.tripbookingdetail.domain.Tripbookingdetail;

public class TripbookingdetailConsoleAdapter {
    private final TripbookingdetailService tripbookingdetailService;

    public TripbookingdetailConsoleAdapter(TripbookingdetailService tripbookingdetailService) {
        this.tripbookingdetailService = tripbookingdetailService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la Id del detalle de la reserva de viaje: ");
                    int createIdTripbooking = scanner.nextInt();

                    System.out.print("Ingrese la Id customers: ");
                    int createIdCustomers = scanner.nextInt();

                    System.out.print("Ingrese la Id Fares: ");
                    int createIdFares = scanner.nextInt();

                    Tripbookingdetail newTripbookingdetail = new Tripbookingdetail(createIdTripbooking, createIdCustomers, createIdFares);
                    tripbookingdetailService.createTripbookingdetail(newTripbookingdetail);

                    break;
                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese la Id del detalle de la reserva de viaje: ");
                    int updateIdTripbooking = scanner.nextInt();

                    System.out.print("Ingrese la Id customers: ");
                    int updateIdCustomers = scanner.nextInt();

                    System.out.print("Ingrese la Id Fares: ");
                    int updateIdFares = scanner.nextInt();

                    Tripbookingdetail updatedTripbookingdetail = new Tripbookingdetail(updateId, updateIdTripbooking, updateIdCustomers, updateIdFares);
                    tripbookingdetailService.updateTripbookingdetail(updatedTripbookingdetail);
                    break;

                case 3:
                    System.out.print("Ingrese el Id del detalle de la reserva de viaje a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Tripbookingdetail> status = tripbookingdetailService.getTripbookingdetailById(findId);
                        status.ifPresentOrElse(
                        p -> System.out.println("ID: " + p.getId() + ", Id trip booking: " + p.getIdTripbooking() + ", Id customers: " + p.getIdCustomers() + ", Id Fares " + p.getIdFares()),
                        () -> System.out.println("Detalle de la reserva de viaje no encontrada")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id del detalle de la reserva de viaje a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    tripbookingdetailService.deleteTripbookingdetail(deleteId);
                    break;

                case 5:
                    tripbookingdetailService.getAllTripbookingdetails().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", Id trip booking: " + p.getIdTripbooking() + ", Id customers: " + p.getIdCustomers() + ", Id Fares " + p.getIdFares());
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
        System.out.println("1. Crear detalle de la reserva de viaje");
        System.out.println("2. Actualizar detalle de la reserva de viaje");
        System.out.println("3. Buscar detalle de la reserva de viaje por ID");
        System.out.println("4. Eliminar detalle de la reserva de viaje");
        System.out.println("5. Listar todos los detalles de las reservas de viaje");
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
