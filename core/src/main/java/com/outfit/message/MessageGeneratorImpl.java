package com.outfit.message;

import org.springframework.stereotype.Component;

@Component
public class MessageGeneratorImpl implements MessageGenerator{

    // == fields ==

    private final Double RAIN_CHANCE = .30; // adjust according to the weather api
    private final String RAINING = "You should bring an umbrella today! Chance of rain is " + RAIN_CHANCE + "% today!";
    private final String NOT_RAINING = "No need to bring an umbrella today! Chance of rain is only " + RAIN_CHANCE + "% today!";

    // == constructors ==

    public MessageGeneratorImpl() {
    }

    // == public methods ==

    @Override
    public String Raining(boolean rain) {
        if(rain) {
            return RAINING;
        } else
            return NOT_RAINING;
    }
}
