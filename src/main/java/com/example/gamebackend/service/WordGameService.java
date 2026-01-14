package com.example.gamebackend.service;



import com.example.gamebackend.model.WordChallenge;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordGameService {

    private final List<String> words;
    private final Random random = new Random();

    public WordGameService() {
        this.words = initializeWords();
    }

    private List<String> initializeWords() {
        return Arrays.asList(
                "KALEM", "MASA", "SANDALYE", "KITAP", "DEFTER",
                "ELMA", "ARMUT", "MEYVE", "SEBZE", "DOMATES",
                "ARABA", "MOTOR", "BISIKLET", "OTOBUS", "TREN",
                "DENIZ", "GUNES", "AYDINLIK", "KARANLIK", "YILDIZ",
                "OKUL", "SINIF", "OGRENCI", "OGRETMEN", "DERS",
                "BILGISAYAR", "TELEFON", "TABLET", "KLAVYE", "FARE",
                "FUTBOL", "BASKET", "VOLEYBOL", "TENIS", "YUZME"
        );
    }

    public List<WordChallenge> generateWordChallenges(int count) {
        List<WordChallenge> challenges = new ArrayList<>();
        List<String> selectedWords = new ArrayList<>(words);
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

    public boolean validateWord(String word) {
        return words.contains(word.toUpperCase());
    }
}