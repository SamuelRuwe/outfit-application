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

    @RequestMapping("signUp")
    public String signUp(Model model) {
        try {
            PersonsDto personsDto = new PersonsDto();
            model.addAttribute("personsDto", personsDto);
            return "signUp";
        } catch (Exception e) {
            e.printStackTrace();
            return "404";
        }
    }

    @RequestMapping("/listClothes")
    public String listClothes(@ModelAttribute Persons persons, Model model) {
        try {
            List<ClothesDto> list = dataService.listClothesDto(persons.getId());
        model.addAttribute("list", list);
        log.info("Persons id = {}", persons.getId());
        return "listClothes";
        }    catch (Exception e) {
        e.printStackTrace();
        return "404";
        }
    }

    @RequestMapping("listClothesInTemp")
    public String listClothesInTemp(@ModelAttribute Persons persons, Model model) {
        try {
            List<ClothesDto> list = dataService.listClothesDtoInTempRange(persons.getId());
            model.addAttribute("list", list);
            return "listClothes";
        }  catch (Exception e) {
            e.printStackTrace();
            return "404";
        }
    }

    @RequestMapping("/editClothes/{clothesId}")
    public String editClothes(@PathVariable(name = "clothesId")int clothesId, Model model, @ModelAttribute Persons persons) {
        try {
            log.info("Persons id = {}", persons.getId());
            ClothesDto clothesDto = new ClothesDto(dataService.getClothes(clothesId));
            List<String> clothingType = dataService.clothingTypes(persons.getId());
            model.addAttribute("clothesDto", clothesDto);
            model.addAttribute("clothingType", clothingType);
            log.info("Persons id = {}", persons.getId());
            return "editClothes";
        }  catch (Exception e) {
            e.printStackTrace();
            return "404";
        }
    }

    @RequestMapping("deleteClothes/{clothesId}")
    public String deleteClothes(@PathVariable(name = "clothesId")int clothesId) {
        try {
            dataService.deleteClothes(clothesId);
            return "redirect:/listClothes";
        }  catch (Exception e) {
            e.printStackTrace();
            return "404";
        }
    }

    @RequestMapping("addClothes")
    public String addClothes(@ModelAttribute Persons persons, Model model) {
        try {
            ClothesDto clothesDto = new ClothesDto();
            clothesDto.setOwnerid(persons.getId());
            List<String> clothingType = dataService.clothingTypes(persons.getId());
            model.addAttribute("clothesDto", clothesDto);
            model.addAttribute("clothingType", clothingType);
            return "addClothes";
        }  catch (Exception e) {
            e.printStackTrace();
            return "404";
        }
    }

    @RequestMapping("saveClothes")
    public String saveClothes(@ModelAttribute ClothesDto clothesDto, @ModelAttribute Persons persons) {
        try {
            log.info("Persons id = {}", persons.getId());
            dataService.saveClothesDto(clothesDto);
            log.info("Persons id = {}", persons.getId());
            return "redirect:/listClothes";
        }  catch (Exception e) {
            e.printStackTrace();
            return "404";
        }
    }

    @RequestMapping("savePerson")
    public String savePerson(PersonsDto personsDto) {
        try {
            Persons persons = new Persons(personsDto);
            dataService.savePersons(persons);
            // create a confirmation page
            return "redirect:/";
        }  catch (Exception e) {
            e.printStackTrace();
            return "404";
        }
    }

    @RequestMapping("weather")
    public String weather() {
        try {
            return "weather";
        } catch (Exception e) {
            e.printStackTrace();
            return "404";
        }
    }
}
