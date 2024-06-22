package com.campuslands.modules.customer.adapter.in;

import com.campuslands.modules.customer.application.CustomerService;
import com.campuslands.modules.customer.domain.Customer;

import java.util.Scanner;
import java.util.List;

public class CustomerConsoleAdapter {
    private CustomerService customerService;

    public CustomerConsoleAdapter(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int id;
        int age;
        int idDocumenttype;
        String name;
        while (true) {
            int choice = menu(scanner);
            
            switch (choice) {
                case 1:
                    List<Customer> customers = customerService.getAllCustomers();
                    System.out.println("Listado de clientes:");
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;
                case 2:
                    System.out.println("Agregar cliente:");
                    System.out.print("Id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    name = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Edad: ");
                    age = scanner.nextInt();
                    System.out.print("id Tipo de documento: ");
                    idDocumenttype = scanner.nextInt();
                    scanner.nextLine();
                    
                    Customer customer = new Customer(id, name, age, idDocumenttype);
                    customerService.createCustomer(customer);
                    break;
                case 3:
                    System.out.println("Actualizar cliente:");
                    System.out.print("Id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo Nombre: ");
                    name = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Nueva Edad: ");
                    age = scanner.nextInt();
                    System.out.print("Nuevo id Tipo de documento: ");
                    idDocumenttype = scanner.nextInt();
                    scanner.nextLine();
                    
                    Customer updatedCustomer = new Customer(id, name, age, idDocumenttype);
                    customerService.updateCustomer(updatedCustomer);
                    break;
                case 4:
                    System.out.println("Borrar cliente:");
                    System.out.print("Id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    customerService.deleteCustomer(id);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ingrese una opcion valida (1 - 5).");
            }
        }
    }

    private int menu(Scanner scanner) {
        System.out.println("Gestor de Aerolinea - Aeropuerto:");
        System.out.println("1. Listar Aerolinea - Aeropuerto");
        System.out.println("2. Agregar Aerolinea - Aeropuerto");
        System.out.println("3. Actualizar Aerolinea - Aeropuerto");
        System.out.println("4. Borrar Aerolinea - Aeropuerto");
        System.out.println("5. Salir");
        System.out.println("");
        System.out.print("Ingrese la opcion: ");
        int choice = -1;
        while (choice < 1 || choice > 5) {
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

