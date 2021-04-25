package com.example.baithi.controller.API;

import com.example.baithi.model.City;
import com.example.baithi.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/city")
public class CityRestController {

    @Autowired
    private CityService cityService;


}
