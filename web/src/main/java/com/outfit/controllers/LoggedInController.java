package com.outfit.controllers;

import com.outfit.domain.Persons;
import com.outfit.dto.ClothesDto;
import com.outfit.dto.PersonsDto;
import com.outfit.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/listClothes")
    public String listClothes(@ModelAttribute Persons persons, Model model) {
        List<ClothesDto> list = dataService.listClothesDto(persons.getId());
//        List<String> clothingType = dataService.clothingTypes(persons.getId());
        model.addAttribute("list", list);
//        model.addAttribute("clothingType", clothingType);
        log.info("Persons id = {}", persons.getId());
        return "listClothes";
    }

//    @RequestMapping("/listClothes/{id}")
//    public String listClothes(@PathVariable(name = "id") int id, Model model) {
//        List<Clothes> list = dataService.listClothes(id);
//        model.addAttribute("list", list);
//        return "listClothes";
//    }

    @RequestMapping("listClothesInTemp")
    public String listClothesInTemp(@ModelAttribute Persons persons, Model model) {
        List<ClothesDto> list = dataService.listClothesDtoInTempRange(persons.getId());
        model.addAttribute("list", list);
        return "listClothes";
    }

//    @RequestMapping(value = "/saveClothes", method = RequestMethod.POST)
//    public String saveClothesDto(@ModelAttribute ClothesDto clothesDto, @ModelAttribute Persons persons) {
//        dataService.saveClothesDto(clothesDto);
//        return "redirect:/listClothes/" + persons.getId();
//    }

    @RequestMapping("/editClothes/{clothesId}")
    public String editClothes(@PathVariable(name = "clothesId")int clothesId, Model model, @ModelAttribute Persons persons) {
        log.info("Persons id = {}", persons.getId());
        ClothesDto clothesDto = new ClothesDto(dataService.getClothes(clothesId));
        List<String> clothingType = dataService.clothingTypes(persons.getId());
        model.addAttribute("clothesDto", clothesDto);
        model.addAttribute("clothingType", clothingType);
        log.info("Persons id = {}", persons.getId());
        return "editClothes";

        /// check and see if this can be a string like the rest of the stuff
    }

    @RequestMapping("deleteClothes/{clothesId}")
    public String deleteClothes(@PathVariable(name = "clothesId")int clothesId) {
        dataService.deleteClothes(clothesId);
        return "redirect:/listClothes";
    }

//    @RequestMapping("addClothes/{id}")
//    public String addClothes(@PathVariable(name = "id")int id, Model model) {
//        Clothes clothes = new Clothes();
//        clothes.setOwnerid(id);
//        model.addAttribute("clothes", clothes);
//        return "addClothes";
//    }

    @RequestMapping("addClothes")
    public String addClothes(@ModelAttribute Persons persons, Model model) {
        ClothesDto clothesDto = new ClothesDto();
        clothesDto.setOwnerid(persons.getId());
        List<String> clothingType = dataService.clothingTypes(persons.getId());
        model.addAttribute("clothesDto", clothesDto);
        model.addAttribute("clothingType", clothingType);
        return "addClothes";
    }

    @RequestMapping("saveClothes")
    public String saveClothes(@ModelAttribute ClothesDto clothesDto, @ModelAttribute Persons persons) {
        log.info("Persons id = {}", persons.getId());
        dataService.saveClothesDto(clothesDto);
        log.info("Persons id = {}", persons.getId());
        return "redirect:/listClothes";
    }

//    @RequestMapping("saveClothes")
//    public String saveClothes(@ModelAttribute Clothes clothes) {
//        dataService.saveClothes(clothes);
//        return "redirect:/listClothes/" + clothes.getOwnerid();
//    }

    @RequestMapping("savePerson")
    public String savePerson(PersonsDto personsDto) {
        Persons persons = new Persons(personsDto);
        dataService.savePersons(persons);
        // create a confirmation page
        return "redirect:/";
    }

    @RequestMapping("weather")
    public String weather() {
        return "weather";
    }
}
