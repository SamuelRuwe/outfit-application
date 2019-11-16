package com.outfit.domain;

import com.outfit.dto.ClothesDto;
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

    public Clothes(ClothesDto clothesDto) {
        this.id = clothesDto.getClothesDtoId();
        this.ownerid = clothesDto.getOwnerid();
        this.type = clothesDto.getType();
        this.color = clothesDto.getColor();
        this.formal = clothesDto.isFormal() ? 1 : 0;
        this.mintemp = clothesDto.getMintemp();
        this.maxtemp = clothesDto.getMaxtemp();
        this.lastworn = clothesDto.getLastworn();
        this.clean = clothesDto.isClean() ? 1 : 0;
    }
}
