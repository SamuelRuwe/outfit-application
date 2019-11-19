package com.outfit.service;

import com.outfit.domain.Clothes;
import com.outfit.domain.Persons;

import java.util.List;

public interface CommonService {

    void savePersons(Persons persons);

    void saveClothes(Clothes clothes);

    List<Persons> listPersons();

    List<Clothes> listClothes();

    List<Clothes> listPersonsClothes(int id);

    Persons getPersons(int id);

    Clothes getClothes(int id);

    void deletePersons(int id);

    void deleteClothes(int id);

    List<Clothes> inTempRange(int id);



    int login(String email, String providedPassword);
}
