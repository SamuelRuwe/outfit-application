package com.outfit.service;

import com.outfit.domain.Clothes;
import com.outfit.domain.Persons;

import java.util.List;

public interface DataService {

    List<Persons> listPersons();

    List<Clothes> listClothes(int id);

    List<Clothes> weatherAppropriateClothes(int id, int zipCode, String countryCode);
}
