package com.campuslands.modules.plane.adapter.in;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.plane.domain.Plane;
import com.campuslands.modules.plane.application.PlaneService;

public class PlaneConsoleAdapter {
    private final PlaneService planeService;

    public PlaneConsoleAdapter(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la capacidad del avion: ");
                    int crateCapacity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese la fecha de fabricacion (formato: yyyy-mm-dd): ");
                    String createfabricationDate = scanner.nextLine();
                    Date createfabricanteDate = Date.valueOf(createfabricationDate);

                    System.out.print("Ingrese el ID del estado del avion: ");
                    int crateIdStatus = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el planeo del avion: ");
                    int crateIdPlane = scanner.nextInt();
                    scanner.nextLine();

                    Plane plane = new Plane(crateCapacity, createfabricanteDate, crateIdStatus, crateIdPlane );
                    planeService.savePlane(plane);
                    break;
                
                case 2:
                    System.out.print("Ingrese ID del avion a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese la nueva capacidad del avion: ");
                    int updateCapacity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese la nueva fecha de fabricacion (formato: yyyy-mm-dd): ");
                    String updatefabricationDate = scanner.nextLine();
                    Date updatefabricanteDate = Date.valueOf(updatefabricationDate);

                    System.out.print("Ingrese el nuevo ID del estado del avion: ");
                    int updateIdStatus = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el nuevo planeo del avion: ");
                    int updateIdPlane = scanner.nextInt();
                    scanner.nextLine();

                    Plane updatedPlane = new Plane(updateId, updateCapacity, updatefabricanteDate, updateIdStatus,updateIdPlane);
                    planeService.updatePlane(updatedPlane);
                    break;

                case 3:
                    System.out.print("Ingrese el Id del avion a buscar: ");
                    int findId = scanner.nextInt();
                    Optional<Plane> plane1 = planeService.findByIdPlane(findId);
                        plane1.ifPresentOrElse(
                        p -> System.out.println("ID: " + p.getId() + ", capacidad:" + p.getCapacity() + ", fecha de fabricacion:" + p.getFabricationDate() + ", idEstatus:" + p.getIdStatus() + "idModelo" + p.getIdModel()),
                        () -> System.out.println("avion no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id del avion a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    planeService.deletePlane(deleteId);
                    break;

                case 5:
                    planeService.findAll().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", capacidad:" + p.getCapacity() + ", fecha de fabricacion:" + p.getFabricationDate() + ", idEstatus:" + p.getIdStatus() + ", idModelo" + p.getIdModel());
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
        System.out.println("1. Crear un avion");
        System.out.println("2. Actualizar un avion");
        System.out.println("3. Buscar un avion por ID");
        System.out.println("4. Eliminar un avion");
        System.out.println("5. Listar todos los avions");
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
