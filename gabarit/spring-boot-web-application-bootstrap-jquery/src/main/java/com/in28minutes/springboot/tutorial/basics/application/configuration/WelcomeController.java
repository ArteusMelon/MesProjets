package com.in28minutes.springboot.tutorial.basics.application.configuration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class WelcomeController {
    

    @RequestMapping("/")
    public ModelAndView homePage() {

        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("title", "Bienvenue de la médiathèque numérique");
        return mav; 
    }
}