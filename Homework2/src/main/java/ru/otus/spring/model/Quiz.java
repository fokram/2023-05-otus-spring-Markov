package ru.otus.spring.model;

import java.util.List;

public class Quiz {
    private final User user;

    private final int passingScore;

    private int score;

    private final List<Question> questions;

    public Quiz(User user, int passingScore, List<Question> questions) {
        this.user = user;
        this.passingScore = passingScore;
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getScore() {
        return score;
    }

    public User getUser() {
        return user;
    }

    public void incScore(int value) {
        score += value;
    }

    public int isPassQuiz() {
        return score >= passingScore ? 1 : 0;
    }
}
