package com.outfit;

import com.outfit.weather.WeatherApiConnection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class ConsoleOutfit {
    // == constants ==
    //private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

//    // == fields ==
//    private Weather weather;
//
////    private PersonService service;
//
//    @Autowired
//    private PersonService service;
//
//    @Autowired
//    private HatService hatService;
//
//    @Autowired
//    private PantsService pantsService;
//
//    @Autowired
//    private ShirtService shirtService;
//
//    @Autowired
//    private JacketService jacketService;
//
//    @Autowired
//    private CommonService commonService;
//
//    public ConsoleOutfit(Weather weather, PersonService service, HatService hatService, PantsService pantsService,
//                         ShirtService shirtService, JacketService jacketService, CommonService commonService) {
//        this.weather = weather;
//        this.service = service;
//        this.hatService = hatService;
//        this.pantsService = pantsService;
//        this.shirtService = shirtService;
//        this.jacketService = jacketService;
//        this.commonService = commonService;
//    }
//
//    // == events ==
//    @EventListener(ContextRefreshedEvent.class)
//    public void start() {
//        log.info("start() --> Container ready for use.");
//        List<Clothes> clothesList = commonService.listPersonsClothes(1);
//        for(Clothes temp : clothesList) {
//            log.info("Type = {}", temp.getType());
//        }
//
////        List<Object[]> list = shirtService.getShirtDetails(1);
////        for(Object item[] : list) {
////            for(int i = 0; i < 2; i++) {
////                log.info("Object detail = {}", item[i]);
////                String s = "Username = " + item[i];
////            }
//
//        Scanner scanner = new Scanner(System.in);
//
//        while(true) {
//            System.out.println("test");
//
//            int  guess = scanner.nextInt();
//            scanner.nextLine();
//
//        }
//    }

    @Autowired
    private WeatherApiConnection weatherApiConnection;


//    public ConsoleOutfit(WeatherApiConnection weatherApiConnection) {
//        this.weatherApiConnection = new WeatherApiConnection("27502", "US");
//    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() --> Container ready for use.");
            Map<String, Object> map = weatherApiConnection.getMaps(27502, "US");
        for (Map.Entry<String,Object> entry : map.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        log.info("Min_temp = {}", map.get("temp_min"));
        log.info("Max_temp = {}", map.get("temp_max"));
    }

}