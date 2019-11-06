package com.outfit;

import com.outfit.domain.Person;
import com.outfit.service.PersonService;
import com.outfit.weather.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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

    public ConsoleOutfit() {

    }

//    private PersonService personService;

    // == constructors ==
//    public ConsoleOutfit(Weather weather) {
//        log.info("Weather bean ??");
//        this.weather = weather;
//        log.info("Current temp = {}", weather.getCurrentTemp());
//    }

//    public ConsoleOutfit(PersonService temp) {
//        this.personService = temp;
//    }

    // == events ==
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() --> Container ready for use.");
        Person person = service.get(1);
        log.info("Person name = {}", person.getUsername());
        Scanner scanner = new Scanner(System.in);


//        Person person = service.get(1);
//        log.info("id = {}", person.getId_person());
//        Long id = 1L;
//        Product product = service.get(2L);
//        log.info("Product = {}", product.getId());
//        log.info("Product = {}", product.getBrand());
//        log.info("Product = {}", product.getName());

        while(true) {
            System.out.println("test");

            int  guess = scanner.nextInt();
            scanner.nextLine();

        }
    }
}
