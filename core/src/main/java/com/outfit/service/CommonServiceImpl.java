package com.outfit.service;

import com.outfit.domain.Clothes;
import com.outfit.domain.Persons;
import com.outfit.dto.LoginDto;
import com.outfit.dto.PersonsDto;
import com.outfit.repo.ClothesRepository;
import com.outfit.repo.PersonsRepository;
import com.outfit.security.PasswordUtils;
import com.outfit.weather.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

    // == fields ==

    @Autowired
    private PersonsRepository personsRepository;
    @Autowired
    private ClothesRepository clothesRepository;
    @Autowired
    private Weather weather;
    @Autowired
    private LoginDto loginDto;
    @Autowired
    private PersonsDto personsDto;

    // == public methods ==

    public void savePersons(Persons persons) {
        personsRepository.save(persons);
    }

    public void saveClothes(Clothes clothes) {
        clothesRepository.save(clothes);
    }

    public List<Persons> listPersons() {
        List list = personsRepository.findAll();
        return list;
    }

    public List<Clothes> listClothes() {
        List list = clothesRepository.findAll();
        return list;
    }

    public List<Clothes> listPersonsClothes(int id) {
        List list = clothesRepository.getOwnedClothes(id);
        return list;
    }
    public Persons getPersons(int id) {
        Persons persons = personsRepository.findById(id).get();
        return persons;
    }

    public Clothes getClothes(int id) {
        Clothes clothes = clothesRepository.findById(id).get();
        return clothes;
    }

    public void deletePersons(int id) {
        personsRepository.deleteById(id);
    }

    public void deleteClothes(int id) {
        clothesRepository.deleteById(id);
    }

    public List<Clothes> inTempRange(int id) {
        Persons tempPerson = getPersons(id);
        log.info("Persons zipcode = {}", tempPerson.getZipcode());
        log.info("Persons name = {}", tempPerson.getFirstname() + " " + tempPerson.getLastname());
        Map<String, String> map = weather.currentTemperature(tempPerson.getZipcode(), tempPerson.getCountrycode());
        int temp_min, temp_max;
        if(map.get("temp_min") != null) {
            temp_min = ((Double)Double.parseDouble(map.get("temp_min"))).intValue();
        } else {
            temp_min = Integer.MIN_VALUE;
        }
        if(map.get("temp_max") != null) {
            temp_max = ((Double)Double.parseDouble(map.get("temp_max"))).intValue() + 1;
        } else {
            temp_max = Integer.MAX_VALUE;
        }

        log.info("temp_min = {}", temp_min);
        log.info("temp_max = {}", temp_max);

        List<Clothes> list = new ArrayList<>(listPersonsClothes(id));
        log.info("list size = {}", list.size());
        List<Clothes> newList = new ArrayList<>();
        Iterator<Clothes> it = list.iterator();
        int i = 0;
        while(it.hasNext()) {
            Clothes tempClothes = it.next();
            if(weather.inTempRange(temp_min, temp_max, tempClothes)) {
                newList.add(tempClothes);
                log.info("Statement is true");
                log.info("newList size = {}", newList.size());
            }
            log.info("i = {}", i);
            i++;
        }
        log.info("newList length = {}", newList.size());
        return newList;
    }

    @Override
    public int login(String email, String providedPassword) {
        Persons temp = personsRepository.getByEmail(email);
        return PasswordUtils.login(temp, providedPassword);
    }
}
