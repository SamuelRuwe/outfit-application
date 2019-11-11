package com.outfit;

import lombok.extern.slf4j.Slf4j;
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
}