package com.example.gamebackend.model;


public class WordChallenge {
    private String scrambledWord;
    private String correctWord;

    public WordChallenge() {
    }

    public WordChallenge(String scrambledWord, String correctWord) {
        this.scrambledWord = scrambledWord;
        this.correctWord = correctWord;
    }

    public String getScrambledWord() {
        return scrambledWord;
    }

    public void setScrambledWord(String scrambledWord) {
        this.scrambledWord = scrambledWord;
    }

    public String getCorrectWord() {
        return correctWord;
    }

    public void setCorrectWord(String correctWord) {
        this.correctWord = correctWord;
    }
}