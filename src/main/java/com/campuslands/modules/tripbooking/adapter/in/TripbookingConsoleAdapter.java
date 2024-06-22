package com.campuslands.modules.tripbooking.adapter.in;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.tripbooking.application.TripbookingService;
import com.campuslands.modules.tripbooking.domain.Tripbooking;

public class TripbookingConsoleAdapter {
    private final TripbookingService tripbookingService;

    public TripbookingConsoleAdapter(TripbookingService tripbookingService) {
        this.tripbookingService = tripbookingService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:

                    System.out.print("Ingrese la fecha de la reserva del viaje: ");
                    Date createDate = Date.valueOf(scanner.nextLine());

                    System.out.println(createDate);
                    System.out.print("Ingrese el id de la reserva de viaje: ");
                    int createIdTrip = scanner.nextInt();

                    Tripbooking newTripbooking = new Tripbooking(createDate, createIdTrip);
                    tripbookingService.createTripbooking(newTripbooking);

                    break;
                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese la fecha de la reserva de viaje: ");
                    Date updateDate = Date.valueOf(scanner.nextLine());

                    System.out.print("Ingrese el id de la reserva de viaje: ");
                    int ipdateIdTrip = scanner.nextInt();

                    Tripbooking updatedTripbooking = new Tripbooking(updateId, updateDate, ipdateIdTrip);
                    tripbookingService.updateTripbooking(updatedTripbooking);
                    break;

                case 3:
                    System.out.print("Ingrese el Id de la reserva de viaje a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Tripbooking> tripbooking = tripbookingService.getTripbookingById(findId);
                        tripbooking.ifPresentOrElse(
                        p -> System.out.println("ID: " + p.getId() + ", fecha: " + p.getDate() + ", id del viaje: " + p.getIdTrip()),
                        () -> System.out.println("Reserva de viaje no encontrada")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id de la reserva de viaje a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    tripbookingService.deleteTripbooking(deleteId);
                    break;

                case 5:
                    tripbookingService.getAllTripbookings().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", fecha: " + p.getDate() + ", id del viaje: " + p.getIdTrip());
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
        System.out.println("1. Crear reserva de viaje");
        System.out.println("2. Actualizar reserva de viaje");
        System.out.println("3. Buscar reserva de viaje por ID");
        System.out.println("4. Eliminar reserva de viaje");
        System.out.println("5. Listar todas las reservas de viaje");
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
