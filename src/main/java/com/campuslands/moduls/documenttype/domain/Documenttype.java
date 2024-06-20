package com.campuslands.moduls.documenttype.domain;

public class Documenttype {
    
    protected int id;
    protected String name;
    
    public Documenttype() {
    }

    public Documenttype(int id, String name) {
        this.id = id;
        this.name = name;
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

    

}
