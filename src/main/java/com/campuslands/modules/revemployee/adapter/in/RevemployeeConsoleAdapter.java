package com.campuslands.modules.revemployee.adapter.in;

import java.util.Optional;
import java.util.Scanner;
import com.campuslands.modules.revemployee.application.RevemployeeService;
import com.campuslands.modules.revemployee.domain.Revemployee;

public class RevemployeeConsoleAdapter {
    private final RevemployeeService revemployeeService;

    public RevemployeeConsoleAdapter(RevemployeeService revemployeeService) {
        this.revemployeeService = revemployeeService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del empleado: ");
                    int createIdEmployee = scanner.nextInt();

                    System.out.print("Ingrese el ID de la revision: ");
                    int createIdRevision = scanner.nextInt();

                    Revemployee revemployee = new Revemployee(createIdEmployee, createIdRevision);
                    revemployeeService.saveRevemployee(revemployee);
                    break;
                
                case 2:
                    System.out.print("Ingrese ID del Reempleado a actualizar: ");
                    int updateId = scanner.nextInt();

                    System.out.print("Ingrese el nuevo ID del empleado: ");
                    int updateIdEmployee = scanner.nextInt();

                    System.out.print("Ingrese el nuevo ID de la revision: ");
                    int updateIdRevision = scanner.nextInt();

                    Revemployee updatedRevemployee = new Revemployee(updateId, updateIdEmployee, updateIdRevision);
                    revemployeeService.updateRevemployee(updatedRevemployee);
                    break;

                case 3:
                    System.out.print("Ingrese el Id del Reempleado a buscar: ");
                    int findId = scanner.nextInt();
                    Optional<Revemployee> revemployee1 = revemployeeService.findByIdRevemployee(findId);
                        revemployee1.ifPresentOrElse(
                        p -> System.out.println("ID: " + p.getId() + ", idEmpleado: " + p.getIdEmployee() + ", idRevision: " + p.getIdRevision()),
                        () -> System.out.println("Reempleado no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id del Reempleado a borrar: ");
                    int deleteId = scanner.nextInt();
                    revemployeeService.deleteRevemployee(deleteId);
                    break;

                case 5:
                    revemployeeService.findAllRevemployee().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", idEmpleado: " + p.getIdEmployee() + ", idRevision: " + p.getIdRevision());
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
        System.out.println("1. Crear un Reempleado");
        System.out.println("2. Actualizar un Reempleado");
        System.out.println("3. Buscar un Reempleado por ID");
        System.out.println("4. Eliminar un Reempleado");
        System.out.println("5. Listar todos los Reempleados");
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
