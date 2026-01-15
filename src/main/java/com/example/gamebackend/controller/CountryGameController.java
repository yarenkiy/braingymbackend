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
    public List<Question> getPlateQuestions(@RequestParam(defaultValue = "tr") String lang) {
        return countryGameService.getPlateCodeQuestions(10, lang);
    }

    @GetMapping("/capitals")
    public List<Question> getCapitalQuestions(@RequestParam(defaultValue = "tr") String lang) {
        return countryGameService.generateCapitalQuestions(10, lang);
    }

    @GetMapping("/cities")
    public List<Question> getCityQuestions(@RequestParam(defaultValue = "tr") String lang) {
        return countryGameService.generateCityQuestions(10, lang);
    }
}