package ru.otus.spring.model;

import java.util.List;
import java.util.Objects;

public class Question {

    private final String questionText;

    private final List<Answer> answers;

    private final String correctAnswerText;

    public Question(String questionText, List<Answer> answers, String correctAnswerText) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswerText = correctAnswerText;
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
        return Objects.equals(
                getQuestionText(),
                question.getQuestionText()
        ) && Objects.equals(
                getAnswers()
                , question.getAnswers()
        ) && Objects.equals(
                correctAnswerText,
                question.correctAnswerText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionText(), getAnswers(), correctAnswerText);
    }
}
