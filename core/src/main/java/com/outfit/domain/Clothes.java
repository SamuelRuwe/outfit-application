package com.outfit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clothes")
@Getter
@Setter
public class Clothes {

    // == fields ==

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
