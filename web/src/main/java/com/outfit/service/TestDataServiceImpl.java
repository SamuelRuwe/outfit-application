package com.outfit.service;

import com.outfit.domain.Clothes;
import com.outfit.domain.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDataServiceImpl implements TestDataService {

    private CommonService commonService;

    @Autowired
    public TestDataServiceImpl(CommonService commonService) {
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
}
