package com.outfit.controllers;

import com.outfit.domain.Person;
import com.outfit.service.DataService;
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

    // == constructor ==
    @Autowired
    public WebController(DataService dataService) {
        this.dataService = dataService;
    }

    // == request methods ==

//    @RequestMapping("/")
//    public String viewHomePage() {
//        log.info("Current temperature is {}", dataService.currentTemp());
//        return "home";
//    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Person> listPersons = dataService.listAllPeople();
        model.addAttribute("listPersons", listPersons);
        return "index";
    }

//    @RequestMapping("/edit/{id}")
//    public ModelAndView showEditProductForm(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("edit_product");
//
//        Person person = dataService.getPerson(id);
//        mav.addObject("person", person);
//        return mav;
//    }
}
