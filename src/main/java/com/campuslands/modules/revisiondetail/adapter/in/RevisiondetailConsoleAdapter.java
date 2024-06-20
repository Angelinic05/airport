package com.campuslands.modules.revisiondetail.adapter.in;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.revisiondetail.application.RevisiondetailService;
import com.campuslands.modules.revisiondetail.domain.Revisiondetail;



public class RevisiondetailConsoleAdapter {
    private final RevisiondetailService revisiondetailService;

    public RevisiondetailConsoleAdapter(RevisiondetailService revisiondetailService) {
        this.revisiondetailService = revisiondetailService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la descripcion: ");
                    String createDescription = scanner.nextLine();

                    System.out.print("Ingrese la id del empleado: ");
                    int idEmployee = scanner.nextInt();

                    Revisiondetail newStatus = new Revisiondetail(createDescription, idEmployee);
                    revisiondetailService.createRevisiondetail(newStatus);

                    break;
                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese la descripcion: ");
                    String updateDescription = scanner.nextLine();

                    System.out.print("Ingrese la id del empleado: ");
                    int updateidEmployee = scanner.nextInt();



                    Revisiondetail updatedRevisiondetail = new Revisiondetail(updateId, updateDescription, updateidEmployee);
                    revisiondetailService.updateRevisiondetail(updatedRevisiondetail);
                    break;

                case 3:
                    System.out.print("Ingrese el Id del detalle de la revision a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Revisiondetail> status = revisiondetailService.getRevisiondetailById(findId);
                        status.ifPresentOrElse(
                        p -> System.out.println("ID: " + p.getId() + ", Descripcion: " + p.getDescription() + " , Id empleado: " + p.getIdEmployee()),
                        () -> System.out.println("detalle de la revision no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id del detalle de la revision a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    revisiondetailService.deleteRevisiondetail(deleteId);
                    break;

                case 5:
                    revisiondetailService.getAllRevisions().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", Descripcion: " + p.getDescription() + " , Id empleado: " + p.getIdEmployee());
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
        System.out.println("1. Crear Detalle de revision");
        System.out.println("2. Actualizar Detalle de revision");
        System.out.println("3. Buscar Detalle de revision por ID");
        System.out.println("4. Eliminar Detalle de revision");
        System.out.println("5. Listar todos los Detalles de las revisiones");
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
