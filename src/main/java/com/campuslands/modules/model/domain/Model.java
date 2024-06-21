package com.campuslands.modules.model.domain;

public class Model {
    String name;
    int idManufactures;

    public Model (){}

    public Model (String name, int idManufactures){
        this.name = name;
        this.idManufactures = idManufactures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdManufactures() {
        return idManufactures;
    }

    public void setIdManufactures(int idManufactures) {
        this.idManufactures = idManufactures;
    }
}
