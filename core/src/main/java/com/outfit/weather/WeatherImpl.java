package com.outfit.weather;

import com.outfit.domain.Clothes;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private WeatherApiConnection weatherApiConnection;


    // == constructors ==
    @Autowired
    public WeatherImpl(@CurrentTemp int currentTemp, @IsRaining boolean isRaining) {
        this.currentTemp = currentTemp;
        this.isRaining = isRaining;
    }

    // == public methods ==

    @Override
    public boolean inTempRange(int temp_min, int temp_max, Clothes clothes) {
        log.info("in inTempRange");
        log.info("Clothes mintemp = {}", clothes.getMintemp());
        log.info("temp_min = {}", temp_min);
        log.info("Clothes maxtemp = {}", clothes.getMaxtemp());
        log.info("temp_max = {}", temp_max);
        if(clothes.getMintemp() < temp_min && clothes.getMaxtemp() > temp_max) {
            log.info("return true");
            return true;
        }
        log.info("return false");
        return false;
    }

    @Override
    public Map<String, String> currentTemperature(int zipCode, String countryCode) {
        log.info("Zipcode = {}", zipCode);
        log.info("Countrycode = {}", countryCode);
        Map<String, Object> map = weatherApiConnection.getMaps(zipCode, countryCode);
        Map<String, String> newMap = new HashMap<>();
        newMap.put("temp_min", map.get("temp_min").toString());
        newMap.put("temp_max", map.get("temp_max").toString());
        return newMap;
    }
}
