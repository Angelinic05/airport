package com.campuslands.moduls.status.adapter.in;

import java.util.Scanner;
import java.util.Optional;

import com.campuslands.moduls.status.application.StatusService;
import com.campuslands.moduls.status.domain.Status;

public class StatusConsoleAdapter {
    private final StatusService statusService;

    public StatusConsoleAdapter(StatusService statusService) {
        this.statusService = statusService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Status");
            System.out.println("2. Actualizar Status");
            System.out.println("3. Buscar Status por ID");
            System.out.println("4. Eliminar Status");
            System.out.println("5. Listar todos Statuses");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opcion: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del status: ");
                    String createName = scanner.nextLine();

                    Status newStatus = new Status(createName);
                    statusService.createStatus(newStatus);

                    break;
                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String updateName = scanner.nextLine();



                    Status updatedStatus = new Status(updateId, updateName);
                    statusService.updateStatus(updatedStatus);
                    break;

                case 3:
                    System.out.print("Ingrese el Id del status a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Status> status = statusService.getStatusById(findId);
            status.ifPresentOrElse(
                        p -> System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre()),
                        () -> System.out.println("Status no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id del status a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    statusService.deleteStatus(deleteId);
                    break;

                case 5:
                    statusService.getAllStatuses().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre());
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
}

