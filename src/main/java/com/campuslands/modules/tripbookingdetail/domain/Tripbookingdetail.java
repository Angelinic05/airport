package com.campuslands.modules.tripbookingdetail.domain;


public class Tripbookingdetail {
    private int id;
    private int idTripbooking;
    private int idCustomers;
    private int idFares;
    private int seatNumber; //numero de asiento


    public Tripbookingdetail() {}

    public Tripbookingdetail(int id, int idTripbooking, int idCustomers, int idFares, int setNumber) {
        this.id = id;
        this.idTripbooking = idTripbooking;
        this.idCustomers = idCustomers;
        this.idFares = idFares;
        this.seatNumber = seatNumber;
    }

    public Tripbookingdetail(int idTripbooking, int idCustomers, int idFares, int seatNumber) {
        this.idTripbooking = idTripbooking;
        this.idCustomers = idCustomers;
        this.idFares = idFares;
        this.seatNumber = seatNumber;
    }

    public Tripbookingdetail(int idTripbooking, int idCustomers, int idFares) {
        this.idTripbooking = idTripbooking;
        this.idCustomers = idCustomers;
        this.idFares = idFares;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTripbooking() {
        return this.idTripbooking;
    }

    public void setIdTripbooking(int idTripbooking) {
        this.idTripbooking = idTripbooking;
    }

    public int getIdCustomers() {
        return this.idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    public int getIdFares() {
        return this.idFares;
    }

    public void setIdFares(int idFares) {
        this.idFares = idFares;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int setNumber) {
        this.seatNumber = setNumber;
    }
}
