package com.outfit.controllers;

import com.outfit.domain.Hat;
import com.outfit.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class WebController {

    // == fields ==

    private DataService dataService;
    private PersonService personService;
    private PantsService pantsService;
    private ShirtService shirtService;
    private HatService hatService;
    private JacketService jacketService;

    // == constructors ==

    @Autowired
    public WebController(DataService dataService, PersonService personService, PantsService pantsService, ShirtService shirtService, HatService hatService, JacketService jacketService) {
        this.dataService = dataService;
        this.personService = personService;
        this.pantsService = pantsService;
        this.shirtService = shirtService;
        this.hatService = hatService;
        this.jacketService = jacketService;
    }

    // == request methods ==

    @RequestMapping("/")
    public String viewHomePage() {
        log.info("Current temperature is {}", dataService.currentTemp());
        return "home";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Hat> listHats = hatService.listAll();
        model.addAttribute("listHats", listHats);
        return "hatTest";
    }

}
