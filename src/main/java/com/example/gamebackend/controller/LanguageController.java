package com.example.gamebackend.controller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/language")
@CrossOrigin(origins = "http://localhost:3000")
public class LanguageController {

    @GetMapping("/translations/{lang}")
    public Map<String, Object> getTranslations(@PathVariable String lang) {
        if ("en".equals(lang)) {
            return getEnglishTranslations();
        }
        return getTurkishTranslations();
    }

    private Map<String, Object> getTurkishTranslations() {
        Map<String, Object> translations = new HashMap<>();

        // Ana menü
        translations.put("mainTitle", "Brain GYM");
        translations.put("mainSubtitle", "Beyin kaslarınızı çalıştırın!");
        translations.put("backToMenu", "←");

        // Oyun isimleri
        translations.put("sudoku", "Sudoku");
        translations.put("sudokuDesc", "Klasik mantık oyunu");
        translations.put("memory", "Hafıza Kartları");
        translations.put("memoryDesc", "Eşleşen kartları bul");
        translations.put("plates", "Ülkeler ve Plaka Kodları");
        translations.put("platesDesc", "Plaka kodlarını tanı");
        translations.put("capitals", "Ülkeler ve Başkentler");
        translations.put("capitalsDesc", "Başkentleri bil");
        translations.put("cities", "Ülkeler ve Şehirler");
        translations.put("citiesDesc", "Şehirleri eşleştir");
        translations.put("words", "Kelime Oyunu");
        translations.put("wordsDesc", "Harfleri sürükle ve kelime yap");

        // Hafıza oyunu
        translations.put("selectTheme", "Tema Seçin");
        translations.put("selectDifficulty", "Zorluk Seviyesi Seçin");
        translations.put("pairs", "Çift");
        translations.put("cards", "Kart");
        translations.put("changeThemeBtn", "← Tema Değiştir");
        translations.put("themeFruits", "Meyveler");
        translations.put("themeAnimals", "Hayvanlar");
        translations.put("themeSports", "Sporlar");
        translations.put("themeVehicles", "Araçlar");
        translations.put("themeHearts", "Kalpler");
        translations.put("themeFlags", "Bayraklar");

        // Genel
        translations.put("score", "Skor");
        translations.put("moves", "Hamle");
        translations.put("time", "Süre");
        translations.put("question", "Soru");
        translations.put("difficulty", "Zorluk");
        translations.put("easy", "Kolay");
        translations.put("medium", "Orta");
        translations.put("hard", "Zor");
        translations.put("children", "Çocuklar İçin");

        // Butonlar
        translations.put("submit", "Gönder");
        translations.put("check", "✓ Kontrol Et");
        translations.put("solution", "💡 Çözümü Göster");
        translations.put("restart", "🔄 Yeniden Başlat");
        translations.put("newGame", "🔄 Yeni Oyun");
        translations.put("changeTheme", "🎨 Tema Değiştir");
        translations.put("playAgain", "🔄 Tekrar Oyna");
        translations.put("backToMenuBtn", "🏠 Ana Menü");

        // Mesajlar
        translations.put("loading", "Yükleniyor...");
        translations.put("congratulations", "🎉 Tebrikler!");
        translations.put("gameOver", "🎉 Oyun Bitti!");
        translations.put("correct", "✓ Doğru!");
        translations.put("wrong", "✗ Yanlış!");
        translations.put("yourScore", "Skorunuz");
        translations.put("successRate", "Başarı Oranı");
        translations.put("completedIn", "Oyunu {moves} hamlede ve {time} sürede tamamladınız!");
        translations.put("correctAnswer", "Doğru cevap");

        // Sorular
        translations.put("whichCountryPlate", "Bu plaka kodu hangi ülkeye ait?");
        translations.put("whichCapital", "ülkesinin başkenti nedir?");
        translations.put("whichCountryCity", "şehri hangi ülkededir?");
        translations.put("dragLetters", "Aşağıdaki harfleri sürükleyerek veya tıklayarak kelime oluşturun:");
        translations.put("dragHere", "Harfleri buraya sürükleyin");

        return translations;
    }

    private Map<String, Object> getEnglishTranslations() {
        Map<String, Object> translations = new HashMap<>();

        // Main menu
        translations.put("mainTitle", "Brain GYM");
        translations.put("mainSubtitle", "Exercise your brain muscles!");
        translations.put("backToMenu", "← Main Menu");

        // Game names
        translations.put("sudoku", "Sudoku");
        translations.put("sudokuDesc", "Classic logic puzzle");
        translations.put("memory", "Memory Cards");
        translations.put("memoryDesc", "Find matching pairs");
        translations.put("plates", "Countries & License Plates");
        translations.put("platesDesc", "Identify license codes");
        translations.put("capitals", "Countries & Capitals");
        translations.put("capitalsDesc", "Know the capitals");
        translations.put("cities", "Countries & Cities");
        translations.put("citiesDesc", "Match the cities");
        translations.put("words", "Word Game");
        translations.put("wordsDesc", "Drag letters to form words");

        // Memory game
        translations.put("selectTheme", "Select Theme");
        translations.put("selectDifficulty", "Select Difficulty Level");
        translations.put("pairs", "Pairs");
        translations.put("cards", "Cards");
        translations.put("changeThemeBtn", "← Change Theme");
        translations.put("themeFruits", "Fruits");
        translations.put("themeAnimals", "Animals");
        translations.put("themeSports", "Sports");
        translations.put("themeVehicles", "Vehicles");
        translations.put("themeHearts", "Hearts");
        translations.put("themeFlags", "Flags");

        // General
        translations.put("score", "Score");
        translations.put("moves", "Moves");
        translations.put("time", "Time");
        translations.put("question", "Question");
        translations.put("difficulty", "Difficulty");
        translations.put("easy", "Easy");
        translations.put("medium", "Medium");
        translations.put("hard", "Hard");
        translations.put("children", "For Children");

        // Buttons
        translations.put("submit", "Submit");
        translations.put("check", "✓ Check");
        translations.put("solution", "💡 Show Solution");
        translations.put("restart", "🔄 Restart");
        translations.put("newGame", "🔄 New Game");
        translations.put("changeTheme", "🎨 Change Theme");
        translations.put("playAgain", "🔄 Play Again");
        translations.put("backToMenuBtn", "🏠 Main Menu");

        // Messages
        translations.put("loading", "Loading...");
        translations.put("congratulations", "🎉 Congratulations!");
        translations.put("gameOver", "🎉 Game Over!");
        translations.put("correct", "✓ Correct!");
        translations.put("wrong", "✗ Wrong!");
        translations.put("yourScore", "Your Score");
        translations.put("successRate", "Success Rate");
        translations.put("completedIn", "You completed the game in {moves} moves and {time}!");
        translations.put("correctAnswer", "Correct answer");

        // Questions
        translations.put("whichCountryPlate", "Which country does this license plate belong to?");
        translations.put("whichCapital", "What is the capital of");
        translations.put("whichCountryCity", "Which country is");
        translations.put("dragLetters", "Drag or click the letters below to form a word:");
        translations.put("dragHere", "Drag letters here");

        return translations;
    }
}