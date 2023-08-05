package ru.otus.spring.exception;

public class QuestionReadException extends RuntimeException {
    public QuestionReadException(String message, Exception e) {
        super(message, e);
    }
}
