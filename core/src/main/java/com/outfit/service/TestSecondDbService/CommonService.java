package com.outfit.service.TestSecondDbService;

import com.outfit.domain.TestSecondDbDomain.Clothes;
import com.outfit.domain.TestSecondDbDomain.Persons;
import com.outfit.repo.TestSecondDbRepo.ClothesRepository;
import com.outfit.repo.TestSecondDbRepo.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    // == fields ==

    @Autowired
    private PersonsRepository personsRepository;
    @Autowired
    private ClothesRepository clothesRepository;

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

}
