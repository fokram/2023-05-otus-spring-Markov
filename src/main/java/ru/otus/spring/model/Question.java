package ru.otus.spring.model;

import java.util.List;
import java.util.Objects;

public class Question {

    private final String questionText;

    private final List<Answer> answers;

    public Question(String questionText, List<Answer> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }


    public List<Answer> getAnswers() {
        return this.answers;
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

        return Objects.equals(getQuestionText(), question.getQuestionText())
                && Objects.equals(getAnswers(), question.getAnswers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionText(), getAnswers());
    }
}
