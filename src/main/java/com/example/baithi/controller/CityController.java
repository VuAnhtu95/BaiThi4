package com.example.baithi.controller;

import com.example.baithi.model.City;
import com.example.baithi.model.Country;
import com.example.baithi.service.city.CityService;
import com.example.baithi.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/list")
    public ModelAndView getAllCity(){
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("city", cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        Iterable<Country> countries = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("country",countries);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCityNew(@Valid @ModelAttribute("city") City city, BindingResult bindingResult){
        city.validate(city,bindingResult);
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/city/create");
            Iterable<Country> countries = countryService.findAll();
            modelAndView.addObject("country",countries);
            return modelAndView;
        }
        cityService.save(city);
        Iterable<Country> countries = countryService.findAll();
        modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("country",countries);
        return modelAndView;
    }

    @GetMapping("/getcity/{id}")
    public ModelAndView showDetailCity(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        ModelAndView modelAndView;
        if (cityOptional.isPresent()) {
            modelAndView = new ModelAndView("/city/detailcity");
            City city = cityOptional.get();
            modelAndView.addObject("city", city);
        } else {
            modelAndView = new ModelAndView("/error-404");
        }
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);

        ModelAndView modelAndView;
        if (cityOptional.isPresent()) {
            modelAndView = new ModelAndView("/city/update");
            Iterable<Country> countries = countryService.findAll();
            modelAndView.addObject("city", cityOptional.get());
            modelAndView.addObject("country", countries);
        } else {
            modelAndView = new ModelAndView("/error-404");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateProduct(@Valid @ModelAttribute("city") City city, BindingResult bindingResult) {
        city.validate(city,bindingResult);
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/city/update");
            Iterable<Country> countries = countryService.findAll();
            modelAndView.addObject("country",countries);
            return modelAndView;
        }
        cityService.save(city);
        Iterable<Country> countries = countryService.findAll();
        Iterable<City> cities = cityService.findAll();

        modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("city", cities);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteConfirmation(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        ModelAndView modelAndView;
        if (cityOptional.isPresent()) {
            modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", cityOptional);
        } else {
            modelAndView = new ModelAndView("error-404");
        }
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute City city) {
        cityService.remove(city.getId());
        return "redirect:/city/list";
    }
}
