package com.campuslands.modules.city.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.campuslands.modules.city.application.CityService;
import com.campuslands.modules.city.domain.City;

public class CityConsoleAdapter {
    
    private CityService cityService;

    public CityConsoleAdapter(CityService cityService) {
        this.cityService = cityService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int id;
        String name;
        int idCountry;
        while (true) {
            int choice = menu(scanner);
            
            switch (choice) {
                case 1:
                    List<City> cities = cityService.findAllCities();
                    cities.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la ciudad: ");
                    name = scanner.nextLine();
                    System.out.print("Ingrese el ID del pais: ");
                    idCountry = scanner.nextInt();
                    scanner.nextLine();
                    City city = new City(name, idCountry);
                    cityService.saveCity(city);
                    break;
                case 3:
                    System.out.print("Ingrese el ID de la ciudad a actualizar: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre de la ciudad: ");
                    name = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del pais: ");
                    idCountry = scanner.nextInt();
                    scanner.nextLine();
                    City updatedCity = new City(id, name, idCountry);
                    cityService.updateCity(updatedCity);
                    break;
                case 4:
                    System.out.print("Ingrese el ID de la ciudad a eliminar: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    cityService.deleteCity(id);
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

    public int menu(Scanner scanner) {
        System.out.println("\nMenu:");
        System.out.println("1. Mostrar todas las ciudades");
        System.out.println("2. Agregar una nueva ciudad");
        System.out.println("3. Actualizar una ciudad");
        System.out.println("4. Eliminar una ciudad");
        System.out.println("5. Salir");
        System.out.println("");
        System.out.print("Ingrese una opcion: ");
        int choice = -1;
        while (choice < 1 || choice > 5) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 5) {                    
                    System.out.println("Ingrese una opcion valida (1 - 5).");
                }
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero.");
            }
        }
        return choice;
    }
}
