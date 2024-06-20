package com.campuslands.modules.plane.domain;

import java.util.Date;

public class Plane {
    int id;
    int capacity;
    Date fabrication_date;
    int idStatus;
    int idModel;

    public Plane(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getFabrication_date() {
        return fabrication_date;
    }

    public void setFabrication_date(Date fabrication_date) {
        this.fabrication_date = fabrication_date;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    
}
