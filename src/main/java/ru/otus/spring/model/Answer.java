package ru.otus.spring.model;

import java.util.Objects;

public class Answer {
    private final String answerText;

    private final Boolean isCorrect;

    public Answer(String answerText, Boolean isCorrect) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public String getAnswerText() {
        return answerText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Answer answer = (Answer) o;

        return Objects.equals(getAnswerText(), answer.getAnswerText()) && Objects.equals(isCorrect, answer.isCorrect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnswerText(), isCorrect);
    }
}
