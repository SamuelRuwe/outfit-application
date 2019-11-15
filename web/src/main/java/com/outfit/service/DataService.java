package com.outfit.service;

import com.outfit.domain.Clothes;
import com.outfit.domain.Persons;

import java.util.List;

public interface DataService {

    List<Persons> listPersons();

    List<Clothes> listClothes(int id);

    List<Clothes> listClothesInTempRange(int id);

    void saveClothes(Clothes clothes);

    Clothes getClothes(int id);

    void deleteClothes(int id);

//    List<LoginDto> getLoginList();

    Persons getPersons(int id);

    int login(String email, String providedpassword);

    void savePersons(Persons persons);

}
