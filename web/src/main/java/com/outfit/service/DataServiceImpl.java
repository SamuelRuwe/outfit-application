package com.outfit.service;

import com.outfit.domain.Clothes;
import com.outfit.domain.Persons;
import com.outfit.weather.WeatherApiConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    private CommonService commonService;
    private WeatherApiConnection weatherApiConnection;

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