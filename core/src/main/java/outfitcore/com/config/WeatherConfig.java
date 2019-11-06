package outfitcore.com.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import outfitcore.com.weather.CurrentTemp;
import outfitcore.com.weather.IsRaining;

@Configuration
@ComponentScan(basePackages = "outfitcore.com")
@PropertySource("classpath:config/application.properties")
@Slf4j
public class WeatherConfig {

    // == fields ==
    @Value("${weather.currentTemp:20}")
    private int currentTemp;

    @Value("${weather.isRaining:false}")
    private boolean isRaining;

    // == bean methods ==
    @Bean
    @CurrentTemp
    private int getCurrentTemp() {
        return currentTemp;
    }

    @Bean
    @IsRaining
    private boolean isRaining() {
        return isRaining;
    }
}
