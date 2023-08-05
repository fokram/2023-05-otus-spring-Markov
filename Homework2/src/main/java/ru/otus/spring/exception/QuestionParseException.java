package ru.otus.spring.exception;

public class QuestionParseException extends RuntimeException {

    public QuestionParseException(String message) {
        super(message);
    }
}
