package com.campuslands.moduls.model.domain;

public class Model {
    int id;
    String name;
    int idManufactures;

    public Model (){}

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

    public int getIdManufactures() {
        return idManufactures;
    }

    public void setIdManufactures(int idManufactures) {
        this.idManufactures = idManufactures;
    }
}
