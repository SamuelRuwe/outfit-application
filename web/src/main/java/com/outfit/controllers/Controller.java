package com.outfit.controllers;

import com.outfit.domain.Clothes;
import com.outfit.dto.LoginDto;
import com.outfit.service.DataService;
import com.outfit.util.OutfitAppMappings;
import com.outfit.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
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

    // == old home call ==

//    @RequestMapping(OutfitAppMappings.HOME)
//    public String viewHomePage(Model model) {
//        List<Persons> list = dataService.listPersons();
//        model.addAttribute("list", list);
//        return ViewNames.HOME;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute LoginDto loginDto) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", loginDto);
        return mav;
    }

    @RequestMapping(OutfitAppMappings.HOME)
    public String viewHomePage(@ModelAttribute LoginDto enteredLoginDto, Model model) {
        log.info("in viewHomePage");
        LoginDto tempLoginDto;
        List<LoginDto> loginList = dataService.getLoginList();
        Iterator<LoginDto> it = loginList.iterator();
        log.info("loginList.size = {}", loginList.size());
        while (it.hasNext()) {
            tempLoginDto = it.next();
            log.info("in while loop");
            log.info("tempLoginDto.getEmail = {}", tempLoginDto.getEmail());
            log.info("tempLoginDto.getPassword = {}", tempLoginDto.getPassword());
            log.info("enteredLoginDto.getEmail = {}", enteredLoginDto.getEmail());
            log.info("enteredLoginDto.getPassword = {}", enteredLoginDto.getPassword());
            if(tempLoginDto.getEmail().equalsIgnoreCase(enteredLoginDto.getEmail()) &&
            tempLoginDto.getPassword().equalsIgnoreCase(enteredLoginDto.getPassword())) {
                model.addAttribute(tempLoginDto.getId());
                return ViewNames.HOME;
            }
        }
        return "redirect:/login";
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
    }

    @RequestMapping("deleteClothes/{id}")
    public String deleteClothes(@PathVariable(name = "id")int id) {
        dataService.deleteClothes(id);
        return "listClothes/" + id;
    }

    @RequestMapping("/addClothes/{id}")
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
}
