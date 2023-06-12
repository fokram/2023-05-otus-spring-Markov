package ru.otus.spring.model;

import java.util.Objects;

public class QuestionEntity {
    private final String question;

    public QuestionEntity(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity question1 = (QuestionEntity) o;
        return getQuestion().equals(question1.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion());
    }
}
