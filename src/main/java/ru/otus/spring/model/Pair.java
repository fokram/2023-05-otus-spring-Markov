package ru.otus.spring.model;

public class Pair {
    private final AnswerEntity answers;

    private final QuestionEntity question;

    public Pair(AnswerEntity answers, QuestionEntity question) {
        this.answers = answers;
        this.question = question;
    }

    public AnswerEntity getAnswers() {
        return this.answers;
    }

    public QuestionEntity getQuestion() {
        return this.question;
    }
}
