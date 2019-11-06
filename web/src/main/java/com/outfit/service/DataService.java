package com.outfit.service;

import com.outfit.domain.Hat;
import com.outfit.domain.Person;

import java.util.List;

public interface DataService {

    int currentTemp();

    boolean isRaining();

    List<Person> listAllPeople();

    void save(Person person);

    Person getPerson(int id);

    void deletePerson(int id);

    List<Hat> listAllHat();

    void save(Hat hat);

    Hat getHat(int id);

    void deleteHat(int id);
}
