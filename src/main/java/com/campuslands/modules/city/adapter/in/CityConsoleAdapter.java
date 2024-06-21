package com.campuslands.modules.city.adapter.in;

import com.campuslands.modules.city.infrastructure.CityRepository;

import java.util.List;
import java.util.Scanner;

import com.campuslands.modules.city.domain.City;

public class CityConsoleAdapter {
    private CityRepository cityRepository;

    public CityConsoleAdapter(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menu(scanner);
            
            switch (choice) {
                case 1:
                    getAllCities();
                    break;
                case 2:
                    saveCity(scanner);
                    break;
                case 3:
                    updateCity(scanner);
                    break;
                case 4:
                    deleteCity(scanner);
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
    public void saveCity(Scanner scanner) {
        System.out.print("Ingrese el nombre de la ciudad: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el ID del pais: ");
        int idCountry = scanner.nextInt();
        scanner.nextLine();
        City city = new City(name, idCountry);
        cityRepository.save(city);
    }
    public void updateCity(Scanner scanner) {
        System.out.print("Ingrese el ID de la ciudad a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre de la ciudad: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el nuevo ID del pais: ");
        int idCountry = scanner.nextInt();
        scanner.nextLine();
        //hacer submenu para seleccionar el campo a actualizar en una funcion aparte
        City city = cityRepository.findById(id).orElse(null);
        if (city == null) {
            System.out.println("No se encontro la ciudad.");
            return;
        }
        city.setName(name);
        cityRepository.update(city);
    }
    public void deleteCity(Scanner scanner) {
        System.out.print("Ingrese el ID de la ciudad a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        cityRepository.findById(id).ifPresent(city -> cityRepository.delete(id));
    }

    public void getAllCities() {
        List<City> cities = cityRepository.findAll();
        cities.forEach(System.out::println);
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
