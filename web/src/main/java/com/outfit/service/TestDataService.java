package com.outfit.service;

import com.outfit.domain.Clothes;
import com.outfit.domain.Persons;

import java.util.List;

public interface TestDataService {

    List<Persons> listPersons();

    List<Clothes> listClothes(int id);

}
