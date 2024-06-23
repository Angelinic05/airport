package com.campuslands.modules.trip.adapter.in;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.trip.application.TripService;
import com.campuslands.modules.trip.domain.Trip;

import java.util.Optional;

public class TripConsoleAdapter {
    private final TripService tripService;

    public TripConsoleAdapter(TripService tripService) {
        this.tripService = tripService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true){
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la fecha del viaje: ");
                    Date createTrip_date = Date.valueOf(scanner.nextLine());

                    System.out.print("Ingrese el precio del viaje: ");
                    double idPrice_tripe = scanner.nextDouble();

                    System.out.print("Ingrese la id ciudad origen: ");
                    int idId_airport_origen = scanner.nextInt();

                    System.out.print("Ingrese la id ciudad destino: ");
                    int idId_airport_destint = scanner.nextInt();

                    Trip newTrip = new Trip(createTrip_date, idPrice_tripe, idId_airport_origen, idId_airport_destint);
                    
                    tripService.createTrip(newTrip);
                    break;

                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese la fecha del viaje: ");
                    Date updateTrip_date = Date.valueOf(scanner.nextLine());

                    System.out.print("Ingrese el precio del viaje: ");
                    double updatePrice_tripe = scanner.nextDouble();

                    System.out.print("Ingrese la id ciudad origen: ");
                    int updateId_airport_origen = scanner.nextInt();

                    System.out.print("Ingrese la id ciudad destino: ");
                    int updateId_airport_destint = scanner.nextInt();

                    scanner.nextLine();

                    Trip updatedTrip = new Trip(updateId, updateTrip_date, updatePrice_tripe, updateId_airport_origen, updateId_airport_destint);
                    tripService.updateTrip(updatedTrip);
                    break;

                case 3:
                    System.out.print("Ingrese el Id del viaje a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Trip> trip = tripService.getTripById(findId);
                    trip.ifPresentOrElse(
                        p -> System.out.println("ID: " + p.getId() + ", viaje Date: " + p.getTripDate() + ", Precio del viaje: " + p.getPriceTripe() + ", Id Ciudad Origen: "+ p.getIdAirportOrigen() + ", IdCiudad Destino: "+ p.getIdAirportDestint()),
                        () -> System.out.println("Viaje no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id del viaje a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    tripService.deleteTrip(deleteId);
                    break;

                case 5:
                    tripService.getAllTrips().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", viaje Date: " + p.getTripDate() + ", Precio del viaje: " + p.getPriceTripe() + ", Id Ciudad Origen: "+ p.getIdAirportOrigen() + ", IdCiudad Destino: "+ p.getIdAirportDestint());
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
        System.out.println("1. Crear Viaje");
        System.out.println("2. Actualizar Viaje");
        System.out.println("3. Buscar Viaje por ID");
        System.out.println("4. Eliminar Viaje");
        System.out.println("5. Listar todos los viajes");
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
