package com.outfit.domain;

import javax.persistence.*;

@Entity
@Table(name = "pants")
public class Pants {

    // == fields ==
    private int pantsid;
    private int ownerid;
    private int mintemp;
    private int maxtemp;
    private int clean;
    private int lastworn;
    private String color;

    // constructors ==

    public Pants() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPantsid() {
        return pantsid;
    }

    public void setPantsid(int pantsid) {
        this.pantsid = pantsid;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public int getMintemp() {
        return mintemp;
    }

    public void setMintemp(int mintemp) {
        this.mintemp = mintemp;
    }

    public int getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(int maxtemp) {
        this.maxtemp = maxtemp;
    }

    public int getClean() {
        return clean;
    }

    public void setClean(int clean) {
        this.clean = clean;
    }

    public int getLastworn() {
        return lastworn;
    }

    public void setLastworn(int lastworn) {
        this.lastworn = lastworn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
