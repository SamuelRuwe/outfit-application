package com.outfit.service;

import com.outfit.domain.Hat;
import com.outfit.domain.Pants;
import com.outfit.domain.Person;

import java.util.List;

public interface DataService {

    void inTempRange();

    String bringUmbrella();

    List<Person> listPersons();

    List<Hat> listHats();

    List<Pants> listPants(int id);

    void savePants(Pants pants);

    Pants getPants(int id);
}
