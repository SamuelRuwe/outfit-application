package com.outfit.controllers;

import com.outfit.domain.TestSecondDbDomain.Clothes;
import com.outfit.domain.TestSecondDbDomain.Persons;
import com.outfit.service.TestDataService;
import com.outfit.util.OutfitAppMappings;
import com.outfit.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@Slf4j
public class Controller {

    // == fields ==

    private TestDataService testDataService;

    // == constructors ==

    @Autowired
    public Controller(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    // == request methods ==

    @RequestMapping(OutfitAppMappings.HOME)
    public String viewHomePage(Model model) {
        List<Persons> list = testDataService.listPersons();
        model.addAttribute("list", list);
        return ViewNames.HOME;
    }

    @RequestMapping("/listClothes/{id}")
    public String listClothes(@PathVariable(name = "id") int id, Model model) {
        List<Clothes> list = testDataService.listClothes(id);
        model.addAttribute("list", list);
        return "listClothes";
    }

}
