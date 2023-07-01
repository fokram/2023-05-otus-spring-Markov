package ru.otus.spring.exception;

public class QuestionException extends Exception {
    private final String resourcePath;

    public QuestionException(String message, String resourcePath) {
        super(message);

        this.resourcePath = resourcePath;
    }

    public String getResourcePath() {
        return resourcePath;
    }
}
