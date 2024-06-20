package com.campuslands.modules.city.domain;

public class City {
    
    protected int id;
    protected String name;
    protected int idCity;
    
    public City() {
    }

    public City(String name, int idCity) {
        this.name = name;
        this.idCity = idCity;
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

    

}
