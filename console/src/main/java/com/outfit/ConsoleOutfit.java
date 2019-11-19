package com.outfit;

import com.outfit.repo.PersonsRepository;
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

    @Autowired
    private WeatherApiConnection weatherApiConnection;

    @Autowired
    CommonService commonService;

    @Autowired
    PersonsRepository personsRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() --> Container ready for use.");
    }

}