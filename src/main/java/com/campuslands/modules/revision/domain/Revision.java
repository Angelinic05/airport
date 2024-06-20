package com.campuslands.modules.revision.domain;


public class Revision {
    private int id;
    private String revisionDate;
    private int idPlane;

    public Revision(int id, String revisionDate, int idPlane){
        this.id = id;
        this.revisionDate = revisionDate;
        this.idPlane = idPlane;
    }
    public Revision() {}

    public Revision(String revisionDate){
        this.revisionDate = revisionDate;
    }
    
    public Revision(int idPlane){
        this.idPlane = idPlane;
    }

    // Getters y setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRevisionDate() {
        return this.revisionDate;
    }

    public void setRevisionDate(String revisionDate) {
        this.revisionDate = revisionDate;
    }

    public int getIdPlane() {
        return this.idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }
}
