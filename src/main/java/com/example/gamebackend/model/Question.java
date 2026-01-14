package com.example.gamebackend.model;


import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private String correctAnswer;
    private String type;

    public Question() {
    }

    public Question(String question, List<String> options, String correctAnswer, String type) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}