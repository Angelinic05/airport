package com.campuslands.modules.airport.domain;

public class Airport {
    protected int id;
    protected String name;
    protected int idCity;
    protected double xPosition;
    protected double yPosition;
    
    public Airport() {
    }
    
    public Airport(int id, String name, int idCity, double xPosition, double yPosition) {
        this.id = id;
        this.name = name;
        this.idCity = idCity;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
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

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    
    
}
