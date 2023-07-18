package ru.otus.spring.service;

import ru.otus.spring.exception.QuestionParseException;
import ru.otus.spring.exception.QuestionReadException;
import ru.otus.spring.utils.QuestionOutputService;

public class AppRunnerImpl implements AppRunner {
    private final QuizService quizService;

    private final OutputService outputService;

    public AppRunnerImpl(QuizService quizService, OutputService outputService) {
        this.quizService = quizService;
        this.outputService = outputService;
    }

    public void run() {
        try {
            quizService.getQuiz()
                    .stream()
                    .map(QuestionOutputService::getOutputString)
                    .forEach(outputService::outputString);
        } catch (QuestionReadException | QuestionParseException e) {
            outputService.outputString(
                    String.format("Error message: %s", e.getMessage())
            );

            e.printStackTrace();
        }
    }
}
