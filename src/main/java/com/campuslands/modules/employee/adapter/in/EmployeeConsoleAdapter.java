package com.campuslands.modules.employee.adapter.in;

import java.util.Optional;
import java.util.Scanner;
import java.sql.Date;
import com.campuslands.modules.employee.application.EmployeeService;
import com.campuslands.modules.employee.domain.Employee;

public class EmployeeConsoleAdapter {

    private final EmployeeService employeeService;

    public EmployeeConsoleAdapter(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el id del empleado: ");
                    int createId = scanner.nextInt();

                    System.out.print("Ingrese el nombre del empleado: ");
                    String createName = scanner.nextLine();

                    System.out.print("Ingrese el ID del rol del empleado: ");
                    int createIdRol = scanner.nextInt();

                    System.out.print("Ingrese la fecha de entrada del empleado (formato: yyyy-mm-dd): ");
                    String createEntryDate = scanner.nextLine();
                    Date sqlDate = Date.valueOf(createEntryDate);

                    System.out.print("Ingrese el ID de la aerolinea del empleado: ");
                    int createIdAirline = scanner.nextInt();

                    System.out.print("Ingrese el ID del aeropuerto del empleado: ");
                    int createIdAirport = scanner.nextInt();

                    Employee employee = new Employee(createId, createName, createIdRol, sqlDate, createIdAirline, createIdAirport);
                    employeeService.saveEmployee(employee);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del empleado a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el nuevo nombre: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Ingrese el nuevo ID del rol del empleado: ");
                    int updateIdRol = scanner.nextInt();

                    System.out.print("Ingrese la nueva fecha de entrada del empleado (formato: yyyy-mm-dd): ");
                    String updateEntryDate = scanner.nextLine();
                    Date updatesqlDate = Date.valueOf(updateEntryDate);

                    System.out.print("Ingrese el nuevo ID de la aerolinea del empleado: ");
                    int updateIdAirline = scanner.nextInt();

                    System.out.print("Ingrese el nuevo ID del aeropuerto del empleado: ");
                    int updateIdAirport = scanner.nextInt();

                    Employee updateEmployee = new Employee(updateId, updateName, updateIdRol, updatesqlDate, updateIdAirline, updateIdAirport);
                    employeeService.updateEmployee(updateEmployee);
                    break;

                case 3:
                    System.out.print("Ingrese el Id del empleado a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Employee> employee1 = employeeService.findByIdEmployee(findId);
                    employee1.ifPresentOrElse( //ifPresentOrElse es un método de la clase Optional que permite manejar el caso en el que el Optional contiene un valor y el caso en el que no contiene un valor.
                        p -> System.out.println("ID:" + p.getId() + ", Nombre : " + p.getName() + ", idRol: " + p.getIdRol() + ", entryDate: " + p.getEntryDate() + ", idAirline: " + p.getIdAirline() + ", idAirport: " + p.getIdAirpot()), // Este método recibe dos argumentos: una acción a realizar si el valor está presente
                        () -> System.out.println("Empleado no encontrado")); //y una acción a realizar si el valor no esta presente
                    break;
                    /*  p: Es un parámetro que representa el objeto contenido en el Optional si está presente.
                        ->: Es el operador lambda que separa los parámetros de la implementación.
                        System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre()): Es la acción a realizar si el Optional contiene un valor.
                        (): Indica que no hay parámetros para la segunda acción.
                        System.out.println("Status no encontrado"): Es la acción a realizar si el Optional no contiene un valor. */

                case 4:
                    System.out.print("Ingrese el Id del empleado a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    employeeService.deleteEmployee(deleteId);
                    break;

                case 5:
                    employeeService.findAllEmployee().forEach(p -> {
                        System.out.println("ID:" + p.getId() + ", Nombre : " + p.getName() + ", idRol: " + p.getIdRol() + ", entryDate: " + p.getEntryDate() + ", idAirline: " + p.getIdAirline() + ", idAirport: " + p.getIdAirpot());
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
        System.out.println("1. Crear empleado");
        System.out.println("2. Actualizar empleado");
        System.out.println("3. Buscar empleado por ID");
        System.out.println("4. Eliminar empleado");
        System.out.println("5. Listar todos empleados");
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
