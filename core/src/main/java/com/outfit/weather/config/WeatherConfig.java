package com.outfit.weather.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.outfit.weather.CurrentTemp;
import com.outfit.weather.IsRaining;

@Configuration
@ComponentScan(basePackages = "com.outfit")
@PropertySource("classpath:config/application.properties")
@Slf4j
public class WeatherConfig {

    // == fields ==
    @Value("${weather.currentTemp:20}")
    public int currentTemp;

    @Value("${weather.isRaining:false}")
    public boolean isRaining;

    // == bean methods ==
    @Bean
    @CurrentTemp
    public int getCurrentTemp() {
        return currentTemp;
    }

    @Bean
    @IsRaining
    public boolean isRaining() {
        return isRaining;
    }

}
