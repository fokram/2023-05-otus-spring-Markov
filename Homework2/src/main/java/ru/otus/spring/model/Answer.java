package ru.otus.spring.model;

import java.util.Objects;

public class Answer {
    private final String answerText;

    private final int isCorrectAnswer;

    public Answer(String answerText, int isCorrectAnswer) {
        this.answerText = answerText;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public String getAnswerText() {
        return answerText;
    }

    public int isCorrectAnswer() {
        return isCorrectAnswer;
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
        return isCorrectAnswer == answer.isCorrectAnswer &&
                Objects.equals(getAnswerText(), answer.getAnswerText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnswerText(), isCorrectAnswer);
    }
}
