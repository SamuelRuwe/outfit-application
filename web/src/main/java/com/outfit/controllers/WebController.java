package com.outfit.controllers;

import com.outfit.domain.Pants;
import com.outfit.domain.Person;
import com.outfit.service.DataService;
import com.outfit.util.OutfitAppMappings;
import com.outfit.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class WebController {

    // == fields ==

    private DataService dataService;

    // == constructors ==

    @Autowired
    public WebController(DataService dataService) {
        this.dataService = dataService;
    }

    // == request methods ==

    @RequestMapping(OutfitAppMappings.HOME)
    public String viewHomePage(Model model) {
        List<Person> listPersons = dataService.listPersons();
        model.addAttribute("listPersons", listPersons);
        return ViewNames.HOME;
    }

    @RequestMapping("/addPants/{id}")
    public String addPants(@PathVariable(name = "id") int id, Model model) {
        Pants pants = new Pants(id);
        model.addAttribute("pants", pants);
        return "addPants";
    }

    @GetMapping("/save-pants")
    @ResponseBody
    public String save(@ModelAttribute Pants pants) {
        dataService.savePants(pants);
        return "Pants Saved Successfully";
    }

    @RequestMapping("/listPants/{id}")
    public String listPants(@PathVariable(name = "id") int id, Model model) {
        List<Pants> listPants = dataService.listPants(id);
        model.addAttribute("listPants", listPants);
        return "listPants";
    }

    @RequestMapping(OutfitAppMappings.VIEW_WARDROBE)
    public String viewHomePage(@PathVariable int id, Model model) {
        List<Pants> list = dataService.listPants(id);
        model.addAttribute("list", list);
       return ViewNames.VIEW_WARDROBE;
    }
}
