package com.campuslands.modules.gate.domain;

public class Gate {
    String gateNumber;
    int idAirport;
    
    public Gate(){}

    public Gate(String gateNumber, int idAirport){
        this.gateNumber = gateNumber;
        this.idAirport = idAirport;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public int getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(int idAirport) {
        this.idAirport = idAirport;
    }  
}
