package com.example.baithi.controller;

import com.example.baithi.model.Country;
import com.example.baithi.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ModelAndView getAllCountry(){
        Iterable<Country> countries = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("country",countries);
        return modelAndView;
    }
}
