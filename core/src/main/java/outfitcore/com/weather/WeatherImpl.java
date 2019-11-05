package outfitcore.com.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties("weather")
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

    public WeatherImpl() {
        isRaining = true;
        currentTemp = 50;
    }
}

//    @Autowired
//    public WeatherImpl(@CurrentTemp int currentTemp, @IsRaining boolean isRaining) {
//        this.currentTemp = currentTemp;
//        this.isRaining = isRaining;
//    }
//}
