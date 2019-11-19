package com.outfit.controllers;

import com.outfit.domain.Persons;
import com.outfit.dto.LoginDto;
import com.outfit.service.DataService;
import com.outfit.util.OutfitAppMappings;
import com.outfit.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
@Slf4j
@SessionAttributes("persons")
public class LoginController {

    // == fields ==

    private DataService dataService;

    // == constructors ==

    @Autowired
    public LoginController(DataService dataService) {
        this.dataService = dataService;
    }

    // == request methods ==

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute LoginDto loginDto) {
        try {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("login", loginDto);
            return mav;
        } catch (Exception e) {
            e.printStackTrace();
            ModelAndView mav = new ModelAndView("404");
            return mav;
        }
    }

    @RequestMapping(OutfitAppMappings.HOME)
    public String viewHomePage(@ModelAttribute LoginDto enteredLoginDto, @ModelAttribute Persons persons,
                               HttpSession session, HttpServletRequest request,
                               Model model) {
        try {
            if (persons != null) {
                return "home";
            }
            log.info("in viewHomePage");
            LoginDto tempLoginDto;
            enteredLoginDto.setId(dataService.login(enteredLoginDto.getEmail(), enteredLoginDto.getPassword()));
            if (enteredLoginDto.getId() != -1) {
//            Persons persons = dataService.getPersons(enteredLoginDto.getId());
                persons = dataService.getPersons(enteredLoginDto.getId());
                model.addAttribute("persons", persons);
                log.info("Session test = {}", session.getAttributeNames().toString());
                log.info("Request Test = {}", request.getAttributeNames());
                model.addAttribute("id", persons.getId());

                /// think i can clean not add the persons object and instead just add id. Will test later 11/15/2019 - SR

                log.info("id = {}", persons.getId());
                return ViewNames.HOME;
            }
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            return "404";
        }
    }

    @ModelAttribute
    public Persons addStuffTest2() {
        Persons persons = null;
        return persons;
    }
}
