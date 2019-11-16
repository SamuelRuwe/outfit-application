package com.outfit.dto;

import com.outfit.domain.Clothes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ClothesDto {

    private int clothesDtoId;
    // is an id necessary for clothes? probably want it but maybe not
    private int ownerid;
    private String type;
    private String color;
    private boolean formal;
    private int mintemp;
    private int maxtemp;
    private int lastworn;
    // change lastworn to a date after this is working
    private boolean clean;

    public ClothesDto() {}

    public ClothesDto(Clothes clothes) {
        this.clothesDtoId = clothes.getId();
        this.ownerid = clothes.getOwnerid();
        this.type = clothes.getType();
        this.color = clothes.getColor();
        this.formal = clothes.getFormal()== 1;
        this.mintemp = clothes.getMintemp();
        this.maxtemp = clothes.getMaxtemp();
        this.lastworn = clothes.getLastworn();
        this.clean = clothes.getClean()==1;
    }
}
