package ru.otus.spring.service;

import ru.otus.spring.exception.QuestionException;

public class AppRunnerImpl implements AppRunner {
    private final QuizService quizService;

    private final OutputService outputService;

    public AppRunnerImpl(QuizService quizService, OutputService outputService) {
        this.quizService = quizService;
        this.outputService = outputService;
    }

    public void run() {
        try {
            quizService.getQuiz().forEach(outputService::outputQuestion);
        } catch (QuestionException e) {
            outputService.outputString(
                    String.format("message: %s", e.getMessage()) +
                            String.format("resourcePath: %s", e.getResourcePath())
            );
        }
    }
}
