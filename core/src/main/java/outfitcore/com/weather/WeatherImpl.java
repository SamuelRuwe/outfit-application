package outfitcore.com.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WeatherImpl implements Weather {

    // == fields ==
    @Getter
    @Setter
    private int currentTemp;

    @Getter
    @Setter
    private boolean isRaining;

    // == constructors ==
    @Autowired
    public WeatherImpl(@CurrentTemp int currentTemp, @IsRaining boolean isRaining) {
        this.currentTemp = currentTemp;
        this.isRaining = isRaining;
    }
}
