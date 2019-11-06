package com.outfit;

import com.outfit.service.*;
import com.outfit.weather.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Slf4j
@Component
public class ConsoleOutfit {
    // == constants ==
    //private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == fields ==
    private Weather weather;

//    private PersonService service;

    @Autowired
    private PersonService service;

    @Autowired
    private HatService hatService;

    @Autowired
    private PantsService pantsService;

    @Autowired
    private ShirtService shirtService;

    @Autowired
    private JacketService jacketService;

    public ConsoleOutfit(Weather weather, PersonService service, HatService hatService, PantsService pantsService,
                         ShirtService shirtService, JacketService jacketService) {
        this.weather = weather;
        this.service = service;
        this.hatService = hatService;
        this.pantsService = pantsService;
        this.shirtService = shirtService;
        this.jacketService = jacketService;
    }

    // == events ==
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() --> Container ready for use.");
        hatService.getOwnersHats(1);
        List<String> list = hatService.getOwnersHats(1);
        for(String hat : list) {
            log.info("Hat color = {}", hat);
        }
        list = pantsService.getOwnersPants(2);
        for(String clothing : list) {
            log.info("Pants color = {}", clothing);
        }
        list = jacketService.getOwnersJacket(3);
        for(String clothing : list) {
            log.info("Jacket color = {}", clothing);
        }
        list = shirtService.getOwnersShirt(1);
        for(String clothing : list) {
            log.info("Shirt color = {}", clothing);
        }
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("test");

            int  guess = scanner.nextInt();
            scanner.nextLine();

        }
    }
}
