package com.outfit.controllers;

import com.outfit.service.DataService;
import com.outfit.util.OutfitAppMappings;
import com.outfit.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String viewHomePage() {
        return ViewNames.HOME;
    }


    @RequestMapping(OutfitAppMappings.VIEW_WARDROBE)
    public String viewHomePage(Model model) {

       return ViewNames.VIEW_WARDROBE;
    }
}
