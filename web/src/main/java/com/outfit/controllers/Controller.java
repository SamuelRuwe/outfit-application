package com.outfit.controllers;

import com.outfit.domain.Clothes;
import com.outfit.domain.Persons;
import com.outfit.service.DataService;
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

    private DataService dataService;

    // == constructors ==

    @Autowired
    public Controller(DataService dataService) {
        this.dataService = dataService;
    }

    // == request methods ==

    @RequestMapping(OutfitAppMappings.HOME)
    public String viewHomePage(Model model) {
        List<Persons> list = dataService.listPersons();
        model.addAttribute("list", list);
        return ViewNames.HOME;
    }

    @RequestMapping("/listClothes/{id}")
    public String listClothes(@PathVariable(name = "id") int id, Model model) {
        List<Clothes> list = dataService.listClothes(id);
        model.addAttribute("list", list);
        return "listClothes";
    }

}
