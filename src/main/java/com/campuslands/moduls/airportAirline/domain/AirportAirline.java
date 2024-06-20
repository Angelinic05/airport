package com.campuslands.moduls.airportAirline.domain;

public class AirportAirline {
    
    protected int id;
    protected int idAirline;
    protected int idAirport;
    
    public AirportAirline() {
    }

    public AirportAirline(int id, int idAirline, int idAirport) {
        this.id = id;
        this.idAirline = idAirline;
        this.idAirport = idAirport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(int idAirline) {
        this.idAirline = idAirline;
    }

    public int getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(int idAirport) {
        this.idAirport = idAirport;
    }

    

}
