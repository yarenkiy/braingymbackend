package com.example.gamebackend.service;



import com.example.gamebackend.model.WordChallenge;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordGameService {

    private final Map<String, List<String>> wordsByLanguage;
    private final Random random = new Random();

    public WordGameService() {
        this.wordsByLanguage = initializeWords();
    }

    private Map<String, List<String>> initializeWords() {
        Map<String, List<String>> words = new HashMap<>();

        // Türkçe kelimeler
        words.put("tr", Arrays.asList(
                "KALEM", "MASA", "SANDALYE", "KITAP", "DEFTER",
                "ELMA", "ARMUT", "MEYVE", "SEBZE", "DOMATES",
                "ARABA", "MOTOR", "BISIKLET", "OTOBUS", "TREN",
                "DENIZ", "GUNES", "AYDINLIK", "KARANLIK", "YILDIZ",
                "OKUL", "SINIF", "OGRENCI", "OGRETMEN", "DERS",
                "BILGISAYAR", "TELEFON", "TABLET", "KLAVYE", "FARE",
                "FUTBOL", "BASKET", "VOLEYBOL", "TENIS", "YUZME"
        ));

        // İngilizce kelimeler
        words.put("en", Arrays.asList(
                "PENCIL", "TABLE", "CHAIR", "BOOK", "NOTEBOOK",
                "APPLE", "PEAR", "FRUIT", "VEGETABLE", "TOMATO",
                "CAR", "MOTOR", "BICYCLE", "BUS", "TRAIN",
                "SEA", "SUN", "LIGHT", "DARK", "STAR",
                "SCHOOL", "CLASS", "STUDENT", "TEACHER", "LESSON",
                "COMPUTER", "PHONE", "TABLET", "KEYBOARD", "MOUSE",
                "FOOTBALL", "BASKETBALL", "VOLLEYBALL", "TENNIS", "SWIMMING",
                "HOUSE", "DOOR", "WINDOW", "GARDEN", "FLOWER",
                "WATER", "FIRE", "EARTH", "WIND", "CLOUD",
                "MUSIC", "DANCE", "SONG", "GUITAR", "PIANO"
        ));

        return words;
    }

    public List<WordChallenge> generateWordChallenges(int count, String language) {
        List<WordChallenge> challenges = new ArrayList<>();
        List<String> wordsForLanguage = wordsByLanguage.getOrDefault(language, wordsByLanguage.get("tr"));
        List<String> selectedWords = new ArrayList<>(wordsForLanguage);
        Collections.shuffle(selectedWords);

        for (int i = 0; i < Math.min(count, selectedWords.size()); i++) {
            String word = selectedWords.get(i);
            String scrambled = scrambleWord(word);
            challenges.add(new WordChallenge(scrambled, word));
        }

        return challenges;
    }

    private String scrambleWord(String word) {
        List<Character> chars = new ArrayList<>();
        for (char c : word.toCharArray()) {
            chars.add(c);
        }

        Collections.shuffle(chars);

        StringBuilder scrambled = new StringBuilder();
        for (char c : chars) {
            scrambled.append(c);
        }

        // Eğer karıştırılmış kelime orijinal ile aynıysa tekrar karıştır
        if (scrambled.toString().equals(word) && word.length() > 1) {
            return scrambleWord(word);
        }

        return scrambled.toString();
    }

    public boolean validateWord(String word, String language) {
        List<String> wordsForLanguage = wordsByLanguage.getOrDefault(language, wordsByLanguage.get("tr"));
        return wordsForLanguage.contains(word.toUpperCase());
    }
}