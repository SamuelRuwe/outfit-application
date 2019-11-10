package com.outfit.domain.TestSecondDbDomain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clothes")
@Getter
@Setter
public class Clothes {

    // == fields ==

    @Id
    @GeneratedValue
    private int id;
    private int ownerid;
    private String type;
    private String color;
    private int formal;
    private int mintemp;
    private int maxtemp;
    private int lastworn;
    private int clean;

    public Clothes() {}
}
