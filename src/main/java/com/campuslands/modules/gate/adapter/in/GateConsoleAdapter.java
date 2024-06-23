package com.campuslands.modules.gate.adapter.in;

import java.util.Optional;
import java.util.Scanner;

import com.campuslands.modules.gate.application.GateService;
import com.campuslands.modules.gate.domain.Gate;



public class GateConsoleAdapter {
    private GateService gateService;

    public GateConsoleAdapter(GateService gateService){
        this.gateService = gateService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el numero de puerta: ");
                    String createGateNumber = scanner.nextLine();
                    scanner.nextLine();

                    System.out.print("Ingrese el ID de aeropuerto: ");
                    int createId = scanner.nextInt();

                    Gate gate = new Gate(createGateNumber, createId);
                    gateService.saveGate(gate);
                    break;

                case 2:

                    System.out.print("Ingrese el ID de la puerta: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el nuevo numero de puerta: ");
                    String updateGateNumber = scanner.nextLine();
                    scanner.nextLine();

                    System.out.print("Ingrese el nuevo ID de aeropuerto: ");
                    int updateIdAirport = scanner.nextInt();

                    Gate gate2 = new Gate(updateId, updateGateNumber, updateIdAirport);
                    gateService.updateGate(gate2);
                    break;

                case 3:
                    System.out.print("Ingrese el Id de la puerta a buscar: ");
                    int findId = scanner.nextInt();
                    Optional<Gate> gate1 = gateService.findByIdGate(findId);
                    gate1.ifPresentOrElse( 
                        p -> System.out.println("ID:" + p.getId() + ", numero de puerta: " + p.getGateNumber() + ", idAirport: " + p.getIdAirport()), 
                        () -> System.out.println("Puerta no encontrada")); 
                    break;

                case 4:
                    System.out.print("Ingrese el Id de la puerta a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    gateService.deleteGate(deleteId);
                    break;

                case 5:
                    gateService.findAllGate().forEach(p -> {
                        System.out.println("ID:" + p.getId() + ", numero de puerta: " + p.getGateNumber() + ", idAirport: " + p.getIdAirport());
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
        System.out.println("1. Crear una puerta");
        System.out.println("2. Actualizar una puerta");
        System.out.println("3. Buscar una puerta");
        System.out.println("4. Eliminar una puerta");
        System.out.println("5. Listar todas las puertas");
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
