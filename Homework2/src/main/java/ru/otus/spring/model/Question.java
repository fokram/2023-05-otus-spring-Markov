package ru.otus.spring.model;

import java.util.List;
import java.util.Objects;

public class Question {
    private final String questionText;

    private final List<Answer> providedAnswers;

    public Question(String questionText, List<Answer> providedAnswers) {
        this.questionText = questionText;
        this.providedAnswers = providedAnswers;
    }

    public List<Answer> getProvidedAnswers() {
        return this.providedAnswers;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question = (Question) o;
        return Objects.equals(
                getQuestionText(),
                question.getQuestionText()
        ) && Objects.equals(
                getProvidedAnswers()
                , question.getProvidedAnswers()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionText(), getProvidedAnswers());
    }
}
