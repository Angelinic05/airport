package com.campuslands.modules.trip.domain;

import java.sql.Date;

public class Trip {
    private int id;
    private Date tripDate;
    private double priceTripe;
    private int idAirportDestint;
    private int idAirportOrigen;

    
    public Trip(int id, Date tripDate, double priceTripe, int idAirportOrigen, int idAirportDestint){
        this.id = id;
        this.tripDate = tripDate;
        this.priceTripe = priceTripe;
        this.idAirportOrigen = idAirportOrigen;
        this.idAirportDestint = idAirportDestint;
    }

    public Trip(Date tripDate, double priceTripe, int idAirportOrigen, int idAirportDestint){
        this.tripDate = tripDate;
        this.priceTripe = priceTripe;
        this.idAirportOrigen = idAirportOrigen;
        this.idAirportDestint = idAirportDestint;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTripDate() {
        return this.tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }

    public double getPriceTripe() {
        return this.priceTripe;
    }

    public void setPriceTripe(double priceTripe) {
        this.priceTripe = priceTripe;
    }

    public int getIdAirportDestint() {
        return this.idAirportDestint;
    }

    public void setIdAirportDestint(int idAirportDestint) {
        this.idAirportDestint = idAirportDestint;
    }

    public int getIdAirportOrigen() {
        return this.idAirportOrigen;
    }

    public void setIdAirportOrigen(int idAirportOrigen) {
        this.idAirportOrigen = idAirportOrigen;
    }


}
