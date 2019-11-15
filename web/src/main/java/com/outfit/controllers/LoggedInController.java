package com.outfit.controllers;

import com.outfit.domain.Clothes;
import com.outfit.domain.Persons;
import com.outfit.dto.PersonsDto;
import com.outfit.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@ControllerAdvice
@SessionAttributes("persons")
public class LoggedInController {

    private DataService dataService;

    @Autowired
    public LoggedInController(DataService dataService) {
        this.dataService = dataService;
    }

    // == pages ==

//    @RequestMapping(OutfitAppMappings.HOME)
//    public String viewHomePage(@ModelAttribute LoginDto enteredLoginDto, Model model) {
//        log.info("in viewHomePage");
//        LoginDto tempLoginDto;
//        enteredLoginDto.setId(dataService.login(enteredLoginDto.getEmail(), enteredLoginDto.getPassword()));
//        if(enteredLoginDto.getId() != -1) {
//            Persons persons = dataService.getPersons(enteredLoginDto.getId());
//            model.addAttribute("persons", persons);
//            model.addAttribute("id", persons.getId());
//            log.info("id = {}", persons.getId());
//            return ViewNames.HOME;
//        }
//        return "redirect:/";
//    }


    @RequestMapping("signUp")
    public String signUp(Model model) {
        PersonsDto personsDto = new PersonsDto();
        model.addAttribute("personsDto", personsDto);
        return "signUp";
    }

    @RequestMapping("/listClothes/{id}")
    public String listClothes(@PathVariable(name = "id") int id, Model model) {
        List<Clothes> list = dataService.listClothes(id);
        model.addAttribute("list", list);
        return "listClothes";
    }

    @RequestMapping("listClothesInTemp/{id}")
    public String listClothesInTemp(@PathVariable(name = "id") int id, Model model) {
        List<Clothes> list = dataService.listClothesInTempRange(id);
        model.addAttribute("list", list);
        return "listClothes";
    }

    @RequestMapping(value = "/saveClothes", method = RequestMethod.POST)
    public String saveClothes(@ModelAttribute Clothes clothes, Model model) {
        dataService.saveClothes(clothes);
        return "redirect:/listClothes/" + clothes.getOwnerid();
    }

    @RequestMapping("/editClothes/{id}")
    public ModelAndView editClothes(@PathVariable(name = "id")int id) {
        ModelAndView mav = new ModelAndView("editClothes");

        Clothes clothes = dataService.getClothes(id);
        mav.addObject("clothes", clothes);
        return mav;

        /// check and see if this can be a string like the rest of the stuff
    }

    @RequestMapping("deleteClothes/{id}")
    public String deleteClothes(@PathVariable(name = "id")int id) {
        dataService.deleteClothes(id);
        return "listClothes/" + id;
    }

    @RequestMapping("addClothes/{id}")
    public String addClothes(@PathVariable(name = "id")int id, Model model) {
        Clothes clothes = new Clothes();
        clothes.setOwnerid(id);
        model.addAttribute("clothes", clothes);
        return "addClothes";
    }

    @RequestMapping("saveClothes")
    public String saveClothes(@ModelAttribute Clothes clothes) {
        dataService.saveClothes(clothes);
        return "redirect:/listClothes/" + clothes.getOwnerid();
    }

    @RequestMapping("savePerson")
    public String savePerson(PersonsDto personsDto) {
        Persons persons = new Persons(personsDto);
        dataService.savePersons(persons);
        // create a confirmation page
        return "redirect:/";
    }

}
