package com.example.gamebackend.controller;



import com.example.gamebackend.model.WordChallenge;
import com.example.gamebackend.service.WordGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/word")
@CrossOrigin(origins = "http://localhost:3000")
public class WordGameController {

    @Autowired
    private WordGameService wordGameService;

    @GetMapping("/challenge")
    public List<WordChallenge> getWordChallenges(@RequestParam(defaultValue = "tr") String lang) {
        return wordGameService.generateWordChallenges(6, lang);
    }

    @PostMapping("/validate")
    public boolean validateWord(@RequestBody String word, @RequestParam(defaultValue = "tr") String lang) {
        return wordGameService.validateWord(word, lang);
    }
}