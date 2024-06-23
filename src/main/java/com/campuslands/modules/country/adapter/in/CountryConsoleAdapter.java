package com.campuslands.modules.country.adapter.in;

import java.util.Scanner;
import com.campuslands.modules.country.application.CountryService;
import com.campuslands.modules.country.domain.Country;
import java.util.List;

public class CountryConsoleAdapter {

    private CountryService countryService;

    public CountryConsoleAdapter(CountryService countryService) {
        this.countryService = countryService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int id;
        String name;
        while (true) {
            int choice = menu(scanner);
            
            switch (choice) {
                case 1:
                    List<Country> cities = countryService.findAllCountries();
                    cities.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del pais: ");
                    name = scanner.nextLine();
                    System.out.print("Ingrese el ID del pais: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    Country country = new Country(id, name);
                    countryService.saveCountry(country);
                    break;
                case 3:
                    System.out.print("Ingrese el ID del pais a actualizar: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del pais: ");
                    name = scanner.nextLine();
                    scanner.nextLine();
                    Country updatedCountry = new Country(id, name);
                    countryService.updateCountry(updatedCountry);
                    break;
                case 4:
                    System.out.print("Ingrese el ID del pais a eliminar: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    countryService.deleteCountry(id);
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Ingrese una opcion valida (1 - 5).");
            }
        }
    }

    public int menu(Scanner scanner) {
        System.out.println("\nMenu:");
        System.out.println("1. Mostrar paises");
        System.out.println("2. Agregar pais");
        System.out.println("3. Actualizar pais");
        System.out.println("4. Eliminar pais");
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
