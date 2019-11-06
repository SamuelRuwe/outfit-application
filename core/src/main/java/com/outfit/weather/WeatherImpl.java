package com.outfit.weather;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WeatherImpl implements Weather {

    // == fields ==

    @Autowired
    @CurrentTemp
    @Getter
    private int currentTemp;

    @Autowired
    @IsRaining
    @Getter
    private boolean isRaining;

    // == constructors ==
    @Autowired
    public WeatherImpl(@CurrentTemp int currentTemp, @IsRaining boolean isRaining) {
        this.currentTemp = currentTemp;
        this.isRaining = isRaining;
    }
}
