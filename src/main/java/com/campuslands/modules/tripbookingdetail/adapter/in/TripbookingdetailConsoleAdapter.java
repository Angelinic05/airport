package com.campuslands.modules.tripbookingdetail.adapter.in;

import java.util.List;
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
        Boolean flag = true;

        while (flag) {
            int choice = menu(scanner);
            int idTripbooking;
            int idCustomers;
            int idFares;
            int seatNumber;

            switch (choice) {
                case 1:
                    System.out.println("Vuelos disponibles: \n");
                    tripbookingdetailService.flightsAvailable().forEach(p -> { //Listar los vuelos disponibles
                        System.out.println("IdTripbooking: " + p.getId() + " date: " + p.getDate() + " idTrip: " + p.getIdTrip());
                    });
                    System.out.print("Ingrese el Id de la reserva de viaje: "); //Seleccionar vuelo disponible
                    idTripbooking = scanner.nextInt();
                    System.out.print("Ingrese el Id del cliente: ");
                    idCustomers = scanner.nextInt();
                    System.out.print("Ingrese el Id de la tarifa: ");
                    idFares = scanner.nextInt();
                    int capacity = tripbookingdetailService.planeCapacity(idTripbooking); //Capacidad que tiene el avion de la reserva de viaje elegida
                    List<Integer> seatsOccupered = tripbookingdetailService.SeatsOccupied(); //Lista de asientos ocupados
                    for (int i = 1; i <= capacity; i++) { if (!seatsOccupered.contains(i)) { System.out.println("Asiento disponible: " + i); } }
                    System.out.println("Ingrese el numero de asiento: ");
                    seatNumber = scanner.nextInt();
                    Tripbookingdetail newTripbookingdetail = new Tripbookingdetail(idTripbooking, idCustomers, idFares, seatNumber);
                    tripbookingdetailService.createTripbookingdetail(newTripbookingdetail);

                    break;
                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Optional<Tripbookingdetail> optionalUpdatedTripbookingdetail = tripbookingdetailService.getTripbookingdetailById(updateId);
                    optionalUpdatedTripbookingdetail.ifPresentOrElse(updatedTripbookingdetail -> {
                        int optSubMenu = -1;
                        String submenu = "¿Qué desea actualizar?\n1. idTripbooking\n2. idCustomers\n3. idFares\n0. Salir\n";
                
                        while (optSubMenu != 0) {
                            System.out.println(submenu);
                            optSubMenu = Integer.parseInt(scanner.nextLine());
                
                            switch (optSubMenu) {
                                case 1:
                                    System.out.print("Ingrese la nueva descripcion: ");
                                    int idTripbookingUpdated = Integer.parseInt(scanner.nextLine());
                                    updatedTripbookingdetail.setIdTripbooking(idTripbookingUpdated);
                                    break;
                                case 2:
                                    System.out.print("Ingrese la nueva descripcion: ");
                                    int idCustomersUpdated = Integer.parseInt(scanner.nextLine());
                                    updatedTripbookingdetail.setIdCustomers(idCustomersUpdated);
                                    break;
                                case 3:
                                    System.out.print("Ingrese el nuevo id de la ciudad: ");
                                    int idFaresUpdated = Integer.parseInt(scanner.nextLine());
                                    updatedTripbookingdetail.setIdFares(idFaresUpdated);
                                    break;
                            }
                        }
                        tripbookingdetailService.updateTripbookingdetail(updatedTripbookingdetail);
                        System.out.println("guardando cambios...");
                    }, () -> System.out.println("No se encontró el detalle de la revision con ID: " + updateId));
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
        System.out.println("1. Crear detalle de la reserva de viaje");
        System.out.println("2. Actualizar detalle de la reserva de viaje");
        System.out.println("3. Buscar detalle de la reserva de viaje por ID");
        System.out.println("4. Eliminar detalle de la reserva de viaje");
        System.out.println("5. Listar todos los detalles de las reservas de viaje");
        System.out.println("0. Salir");
        System.out.println("");
        System.out.print("Ingrese la opcion: ");
        int choice = -1;
        while (choice < 0 || choice > 5) {
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
