package com.campuslands.modules.trip.domain;

import java.sql.Date;

public class Trip {
    private int id;
    private Date tripDate;
    private double princeTripe;
    private int idAirportDestint;
    private int idAirportOrigen;

    
    public Trip(int id, Date tripDate, double princeTripe, int idAirportOrigen, int idAirportDestint){
        this.id = id;
        this.tripDate = tripDate;
        this.princeTripe = princeTripe;
        this.idAirportOrigen = idAirportOrigen;
        this.idAirportDestint = idAirportDestint;
    }

    public Trip(Date tripDate, double princeTripe, int idAirportOrigen, int idAirportDestint){
        this.tripDate = tripDate;
        this.princeTripe = princeTripe;
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

    public double getPrinceTripe() {
        return this.princeTripe;
    }

    public void setPrinceTripe(double princeTripe) {
        this.princeTripe = princeTripe;
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
