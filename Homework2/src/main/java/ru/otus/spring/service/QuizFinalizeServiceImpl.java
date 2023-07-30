package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.model.Quiz;

@Service
public class QuizFinalizeServiceImpl implements QuizFinalizeService {
    private final OutputService outputService;

    public QuizFinalizeServiceImpl(OutputService outputService) {
        this.outputService = outputService;
    }

    @Override
    public void finalizeQuiz(Quiz quiz) {
        if (quiz.isPassQuiz() == 1) {
            outputService.outputString(
                    String.format("Dear %s, you have passed the Test", quiz.getUser().getFullName())
            );
        } else {
            outputService.outputString(
                    String.format("Dear %s, you haven't passed the Test", quiz.getUser().getFullName())
            );
        }

        outputService.outputString(
                String.format("Count correct answer is %d", quiz.getScore())
        );
        outputService.outputString(
                String.format("Count incorrect answer is %d", quiz.getQuestions().size() - quiz.getScore())
        );
    }
}
