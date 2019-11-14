package com.outfit;

import com.outfit.repo.PersonsRepository;
import com.outfit.security.PasswordUtils;
import com.outfit.service.CommonService;
import com.outfit.weather.WeatherApiConnection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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
//    private CommonServiceImpl commonService;
//
//    public ConsoleOutfit(Weather weather, PersonService service, HatService hatService, PantsService pantsService,
//                         ShirtService shirtService, JacketService jacketService, CommonServiceImpl commonService) {
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

    @Autowired
    CommonService commonService;

    @Autowired
    PersonsRepository personsRepository;


//    public ConsoleOutfit(WeatherApiConnection weatherApiConnection) {
//        this.weatherApiConnection = new WeatherApiConnection("27502", "US");
//    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() --> Container ready for use.");
        String salt = PasswordUtils.getSalt(30);
        log.info("salt = {}", salt);
        String securePassword = PasswordUtils.generateSecurePassword("2345", salt);
        log.info("securePassword = {}", securePassword);
        salt = PasswordUtils.getSalt(30);
        log.info("salt = {}", salt);
        securePassword = PasswordUtils.generateSecurePassword("4444", salt);
        log.info("securePassword = {}", securePassword);
        salt = PasswordUtils.getSalt(30);
        log.info("salt = {}", salt);
        securePassword = PasswordUtils.generateSecurePassword("erinlogin", salt);
        log.info("securePassword = {}", securePassword);
//        Boolean test = PasswordUtils.verifyUserPassword("1234", "FU6vbvs91K0qS1g3Wy8dQSDHJFsud5OW0dPGEzxEuY4=", "n73zJyQzLebqSVqfX9mMjDzPTN1BEY");
//        String testString = test.toString();
//        log.info("testString = {}", testString);
//        Persons temp = personsRepository.getByEmail("ruwesam@gmail.com");
//        log.info("temp = {}", temp.getFirstname());
//        int test = commonService.login("ruwesam@gmail.com", "1234");
//        int test = PasswordUtils.login("ruwesam@gmail.com", "1234");
//        log.info("test = {}", test);



//        Map<String, Object> map = weatherApiConnection.getMaps(27502, "US");
//        System.out.println(map.get("temp_min"));


//            Map<String, Object> map = weatherApiConnection.getMaps(27502, "US");
//        for (Map.Entry<String,Object> entry : map.entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
//        log.info("Min_temp = {}", map.get("temp_min"));
//        log.info("Max_temp = {}", map.get("temp_max"));
    }

}