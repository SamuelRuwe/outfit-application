package com.outfit.weather;

import com.outfit.domain.Clothes;

import java.util.Map;

public interface Weather {

    int getCurrentTemp();

    boolean isRaining();

    boolean inTempRange(int temp_min, int temp_max, Clothes clothes);

    Map<String, String> currentTemperature(int zipCode, String countryCode);
}
