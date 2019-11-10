package com.outfit.service;

import com.outfit.domain.Hat;
import com.outfit.domain.Pants;
import com.outfit.domain.Person;
import com.outfit.message.MessageGenerator;
import com.outfit.weather.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class DataServiceImpl implements DataService {

    // == fields ==

    private PersonService personService;
    private PantsService pantsService;
    private ShirtService shirtService;
    private HatService hatService;
    private JacketService jacketService;
    private Weather weather;
    private MessageGenerator messageGenerator;

    // == constructors ==

    @Autowired
    public DataServiceImpl(PersonService personService, PantsService pantsService, ShirtService shirtService, HatService hatService, JacketService jacketService, Weather weather,
                           MessageGenerator messageGenerator) {
        this.personService = personService;
        this.pantsService = pantsService;
        this.shirtService = shirtService;
        this.hatService = hatService;
        this.jacketService = jacketService;
        this.weather = weather;
        this.messageGenerator = messageGenerator;
    }

    // == init ==

    @PostConstruct
    public void init() {
        log.info("Weather currentTemp = {}", weather.getCurrentTemp(),
                "Weather isRaining = {}", weather.isRaining());
    }

    // == public methods ==

    @Override
    public void inTempRange() {

    }

    @Override
    public String bringUmbrella() {
        return messageGenerator.Raining(weather.isRaining());
    }

    @Override
    public List<Person> listPersons() {
        return personService.listAll();
    }

    @Override
    public List<Hat> listHats() {
        return hatService.listAll();
    }

    @Override
    public List<Pants> listPants(int id) {
        return pantsService.getPantsDetails(id);
    }

    @Override
    public void savePants(Pants pants) {
        pantsService.save(pants);
    }

    @Override
    public Pants getPants(int id) {
        return pantsService.get(id);
    }
}
