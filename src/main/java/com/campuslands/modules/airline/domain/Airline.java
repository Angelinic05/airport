package com.campuslands.modules.airline.domain;

public class Airline{
    protected int id; //Atributos de la clase Airline
    protected String name;

    //La palabra clave protected es un modificador de acceso
    
    public Airline(int id, String name) { //Constructor de la clase, este se realiza para poder instanciar las clases
        this.id = id;
        this.name = name;
    }

    public Airline(String name) {
        this.name = name;
    }

    public Airline() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() { 
        return String.format("Airline id=%d, name='%s' ", id, name);
    } 

    //toString es una funcion propia de Java, aca lo que hacemos es realizar polimorfismo con esta funcion y dentro de esta. ponerle lo que queremos imprimir,
    //primero agregamos el string que queremos imprimir asi: "Airline id = %d". El "%" es para indicar que vamos a utilizar una variable ahi, y lo que va 
    //despues del "%" es el tipo de variable que vamos a utilizar, asi: "%d" -> d significa digito ENTERO, s -> significa string, date se pasa como un metodo, asi:
    //entryDate.toString();, f -> significa para digitos con decimal
    

}