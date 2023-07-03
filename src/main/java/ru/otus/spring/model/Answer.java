package ru.otus.spring.model;

import java.util.Objects;

public class Answer {
    private final String answerText;

    public Answer(String answerText) {
        this.answerText = answerText;
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

        return Objects.equals(getAnswerText(), answer.getAnswerText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnswerText());
    }
}
