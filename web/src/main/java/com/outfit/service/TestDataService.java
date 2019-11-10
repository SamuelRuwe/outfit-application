package com.outfit.service;

import com.outfit.domain.TestSecondDbDomain.Clothes;
import com.outfit.domain.TestSecondDbDomain.Persons;

import java.util.List;

public interface TestDataService {

    List<Persons> listPersons();

    List<Clothes> listClothes(int id);

}
