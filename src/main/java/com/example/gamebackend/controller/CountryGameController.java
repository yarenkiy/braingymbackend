package com.example.gamebackend.controller;



import com.example.gamebackend.model.Question;
import com.example.gamebackend.service.CountryGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@CrossOrigin(origins = "http://localhost:3000")
public class CountryGameController {

    @Autowired
    private CountryGameService countryGameService;

    @GetMapping("/plates")
    public List<Question> getPlateQuestions() {
        return countryGameService.getPlateCodeQuestions(10);
    }

    @GetMapping("/capitals")
    public List<Question> getCapitalQuestions() {
        return countryGameService.generateCapitalQuestions(10);
    }

    @GetMapping("/cities")
    public List<Question> getCityQuestions() {
        return countryGameService.generateCityQuestions(10);
    }
}