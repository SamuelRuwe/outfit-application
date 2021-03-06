package com.outfit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping(value = "logout")
    public String logout(SessionStatus session, HttpSession httpSession) {
        try {
            session.isComplete();
            httpSession.invalidate();
            return "redirect:/";
        }  catch (Exception e) {
            httpSession.invalidate();
            e.printStackTrace();
            return "404";
        }
    }
}
