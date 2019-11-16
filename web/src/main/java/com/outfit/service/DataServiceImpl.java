package com.outfit.service;

import com.outfit.domain.Clothes;
import com.outfit.domain.Persons;
import com.outfit.dto.ClothesDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class DataServiceImpl implements DataService {

    private CommonService commonService;

    @Autowired
    public DataServiceImpl(CommonServiceImpl commonService) {
        this.commonService = commonService;
    }

    @Override
    public List<Persons> listPersons() {
        return commonService.listPersons();
    }

    @Override
    public List<Clothes> listClothes(int id) {
        return commonService.listPersonsClothes(id);
    }

    @Override
    public List<Clothes> listClothesInTempRange(int id) {
        return commonService.inTempRange(id);
    }

    @Override
    public void saveClothes(Clothes clothes) {
        commonService.saveClothes(clothes);
    }

    @Override
    public Clothes getClothes(int id) {
        return commonService.getClothes(id);
    }

    @Override
    public void deleteClothes(int id) {
        commonService.deleteClothes(id);
    }

//    @Override
//    public List<LoginDto> getLoginList() {
//        Iterator<LoginDto> it = commonService.loginCheckList().iterator();
//        while(it.hasNext()) {
//            LoginDto temp = it.next();
//            log.info("temp email = {}", temp.getEmail());
//        }
//        return commonService.loginCheckList();
//    }

    @Override
    public Persons getPersons(int id) {
        return commonService.getPersons(id);
    }

    @Override
    public int login(String email, String providedpassword) {
        return commonService.login(email, providedpassword);
    }

    @Override
    public void savePersons(Persons persons) {
        commonService.savePersons(persons);
    }

    @Override
    public List<ClothesDto> listClothesDto(int id) {
        List<Clothes> listClothes = commonService.listPersonsClothes(id);
        Iterator<Clothes> it = listClothes.iterator();
        List<ClothesDto> listClothesDto = new ArrayList<>();
        while (it.hasNext()) {
            ClothesDto temp = new ClothesDto(it.next());
            listClothesDto.add(temp);
        }
        return listClothesDto;
    }

    @Override
    public void saveClothesDto(ClothesDto clothesDto) {
        Clothes temp = new Clothes(clothesDto);
        commonService.saveClothes(temp);
    }

    @Override
    public List<String> clothingTypes(int id) {
        List<String> clothingTypes = new ArrayList();
        List clothingList = commonService.listPersonsClothes(id);
        Iterator<Clothes> it = clothingList.iterator();
        while (it.hasNext()) {
            Clothes temp = it.next();
            if (!clothingTypes.contains(temp.getType())) {
                clothingTypes.add(temp.getType());
            }
        }
        return clothingTypes;
        // should this be in the core module or here?

        //    @Override
//    public List<Clothes> weatherAppropriateClothes(int id, int zipCode, String countryCode) {
//        List<Clothes> list = new ArrayList<>();
//        Map<String, Object> map = weatherApiConnection.getMaps(zipCode, countryCode);
//        int minTemp = Integer.parseInt((String) (map.get("temp_min")));
//        int maxTemp = Integer.parseInt((String) (map.get("temp_max"))) + 1; // add one due to truncation of value (79.9 -- > 79)
//        List<Clothes> clothesList = commonService.listPersonsClothes(id);
//        for (Clothes temp : clothesList) {
//            if (temp.getMintemp() < minTemp && temp.getMaxtemp() < maxTemp) {
//                list.add(temp);
//            }
//        }
//        return list; //////////////// haven't checked to see if this works yet so I don't know!
//    }
    }

    @Override
    public List<ClothesDto> listClothesDtoInTempRange(int id) {
        List<Clothes> listClothes = listClothesInTempRange(id);
        Iterator<Clothes> it = listClothes.iterator();
        List<ClothesDto> listClothesDto = new ArrayList<>();
        while (it.hasNext()) {
            ClothesDto temp = new ClothesDto(it.next());
            listClothesDto.add(temp);
        }
        return listClothesDto;
    }

    // this is repeated code. See if there's a way to not repeat it
}