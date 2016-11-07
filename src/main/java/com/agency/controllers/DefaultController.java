package com.agency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vladimir on 01.11.2016.
 */
@Controller
public class DefaultController {
    @RequestMapping("/")
    public String redirectToProducts() {

        return "redirect:/real_estates";
    }
}
