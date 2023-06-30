package ru.otus.spring.model;

import java.util.Objects;

public class Question {
    private final String question;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return getQuestion().equals(question1.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion());
    }

    @Override
    public String toString() {
        return question;
    }
}
