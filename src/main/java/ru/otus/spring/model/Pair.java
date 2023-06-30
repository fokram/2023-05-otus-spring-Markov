package ru.otus.spring.model;

public class Pair {
    private final AnswerEntity answers;

    private final Question question;

    public Pair(AnswerEntity answers, Question question) {
        this.answers = answers;
        this.question = question;
    }

    public AnswerEntity getAnswers() {
        return this.answers;
    }

    public Question getQuestion() {
        return this.question;
    }
}
