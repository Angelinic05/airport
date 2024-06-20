package com.campuslands.moduls.employee.domain;

import java.util.Date; //importacion de fecha de java

public class Employee {
    int id;
    String name;
    int idRol;
    Date ingresesdate;
    int idAirline;
    int idAirpot;

    public Employee(){} //Constructor vacio


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
        return idAirpot;
    }
    public void setIdAirpot(int idAirpot) {
        this.idAirpot = idAirpot;
    }    

    
}


