package com.outfit.domain;

import javax.persistence.*;

@Entity
@Table(name = "hat")
public class Hat {

    // == fields ==

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHat;
    private int idPerson;
//    @Column(name = "formal", nullable = false)
//    @Type(type = "org.hibernate.type.NumericBooleanType")
//    potential way to use a boolean from an int. Will test later. Going to use com.outfit.config class for now. 11/5/2019

    private int formal;
    private String color;
    private int minTemp;
    private int maxTemp;
//    @Column(name = "clean", nullable = false)
//    @Type(type = "org.hibernate.type.NumericBooleanType")
    private int clean;
    private int lastWorn;

    // constructors ==

    public Hat() {}

    public int getIdHat() {
        return idHat;
    }

    public void setIdHat(int idHat) {
        this.idHat = idHat;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int isFormal() {
        return formal;
    }

    public void setFormal(int formal) {
        this.formal = formal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int isClean() {
        return clean;
    }

    public void setClean(int clean) {
        this.clean = clean;
    }

    public int getLastWorn() {
        return lastWorn;
    }

    public void setLastWorn(int lastWorn) {
        this.lastWorn = lastWorn;
    }

    public boolean checkBoolean(int i) {
        return i == 1;
    }
}
