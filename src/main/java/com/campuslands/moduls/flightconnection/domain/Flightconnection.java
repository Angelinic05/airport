package com.campuslands.moduls.flightconnection.domain;

public class Flightconnection {
    int id;
    String connectionNumber;
    int idTrip;
    int idPlane;
    int idAirport;

    public Flightconnection(){}
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getConnectionNumber() {
        return connectionNumber;
    }
    public void setConnectionNumber(String connectionNumber) {
        this.connectionNumber = connectionNumber;
    }
    public int getIdTrip() {
        return idTrip;
    }
    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }
    public int getIdPlane() {
        return idPlane;
    }
    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }
    public int getIdAirport() {
        return idAirport;
    }
    public void setIdAirport(int idAirport) {
        this.idAirport = idAirport;
    }

    
}
