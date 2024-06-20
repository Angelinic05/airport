package com.campuslands.modules.employee.domain;

import java.util.Date; //importacion de fecha de java

public class Employee {
    int id;
    String name;
    int idRol;
    Date ingresesdate;
    int idAirline;
    int idAirport;

    public Employee(){} //Constructor vacio

    public Employee(int id, String name, int idRol, Date ingresesdate, int idAirline, int idAirport){
        this.id = id;
        this.name = name;
        this.idRol = idRol;
        this.ingresesdate = ingresesdate;
        this.idAirline = idAirline;
        this.idAirport = idAirport;
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
    public int getIdRol() {
        return idRol;
    }
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    public Date getIngresesdate() {
        return ingresesdate;
    }
    public void setIngresesdate(Date ingresesdate) {
        this.ingresesdate = ingresesdate;
    }
    public int getIdAirline() {
        return idAirline;
    }
    public void setIdAirline(int idAirline) {
        this.idAirline = idAirline;
    }
    public int getIdAirpot() {
        return idAirport;
    }
    public void setIdAirpot(int idAirpot) {
        this.idAirport = idAirpot;
    }    

    
}


