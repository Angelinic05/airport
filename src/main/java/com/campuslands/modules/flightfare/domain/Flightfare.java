package com.campuslands.modules.flightfare.domain;

public class Flightfare {
    String descripcion;
    String details;
    double value;

    public Flightfare(){}

    public Flightfare(String descripcion, String details, double value){
        this.descripcion = descripcion;
        this.details = details;
        this.value = value;
    }
   
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetails(){
        return details;
    }

    public void setDetails(String details){
        this.details = details;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
