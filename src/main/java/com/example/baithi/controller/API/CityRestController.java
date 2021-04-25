package com.example.baithi.controller.API;

import com.example.baithi.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/city")
public class CityRestController {

    @Autowired
    private CityService cityService;

    //// cái controller này tạo ra cho vui
}
