package ru.otus.spring.model;

import java.util.List;
import java.util.Objects;

public class AnswerEntity {
    private final List<String> answers;

    public AnswerEntity(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getAnswers() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerEntity answer = (AnswerEntity) o;
        return getAnswers().equals(answer.getAnswers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnswers());
    }
}
