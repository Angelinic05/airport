package com.campuslands;

import java.util.Scanner;

import com.campuslands.modules.plane.adapter.in.PlaneConsoleAdapter;
import com.campuslands.modules.plane.adapter.out.PlaneMySQLRepository;
import com.campuslands.modules.plane.application.PlaneService;

public class Menu {
    public static void main(String[] args) {
        System.out.println("hola");
        Scanner sc = new Scanner(System.in);

        menu(sc);
    }

    public static void menu(Scanner sc){

        String url = "jdbc:mysql://javaairportdb.cfecucemoghu.us-east-2.rds.amazonaws.com:3306/airport";
        String username = "airportDB";
        String password = "AngeliKikeMichi";

        int choice;
        while(true){
            System.out.println("Bienvenido a Airport MichKiAn \3");
            System.out.println("Seleccione el usuario al que desea ingresar: \n \4 1. Administrador del Sistema \n \4 2. Agente de Ventas \n \4 3. Tecnico de Mantenimiento \n \4 4. Cliente \n \4 5. Salir");
            switch (choice = Integer.parseInt(sc.nextLine())) {
                case 1:
                
                    opcionesAdministrador(sc, url, username, password);
                    System.out.println("hols");


                    
                    break;
                case 2:

                System.out.println("hols");

                    break;

                case 3:

                System.out.println("hols");

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Bye:)");
                    break;

                default:
                    break;
            }

        }
    
    }

    public static void opcionesAdministrador(Scanner sc, String url, String username, String password){
        int choice;
        while(true){
            System.out.println("Ahora se encuentra en el usuario de ADMINISTRADOR \5");
            System.out.println("Digite la opcion a la que desea ingresar: \n \6 1. Aviónes " + 
            "\n \6 2. Trayectos \n \6 3. Aeropuertos \n \6 4. Escalas \n \6 5. Tarifas de vuelo" +
            "\n \6 6. Tipos de Documentos");
            switch (choice = Integer.parseInt(sc.nextLine())) {
                case 1:

                    System.out.println("plane");
                    PlaneMySQLRepository planeMySQLRepository = new PlaneMySQLRepository(url, username, password);
                    PlaneService planeService = new PlaneService(planeMySQLRepository);
                    PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planeService);
                    planeConsoleAdapter.start();
                

                    System.out.println("hols");


                    
                    break;
                case 2:

                System.out.println("hols");

                    break;

                case 3:

                System.out.println("hols");

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Bye:)");
                    break;

                default:
                    break;
            }

        }
        
    }

   



    
}
