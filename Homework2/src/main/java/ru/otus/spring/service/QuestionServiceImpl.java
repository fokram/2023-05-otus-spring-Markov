package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final IOService ioService;

    public QuestionServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public int processQuestionAndGetScoreIncrement(Question question) {
        ioService.outputString(question.getQuestionText());
        ioService.outputString("Choose one correct answer provided below");

        question.getProvidedAnswers().stream()
                .map(Answer::getAnswerText)
                .forEach(ioService::outputString);

        return getScoreIncrement(question);
    }

    private int getScoreIncrement(Question question) {
        while (true) {
            try {
                return question.getProvidedAnswers()
                        .get(ioService.readIntWithPrompt("Choose number: "))
                        .isCorrectAnswer();
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                ioService.outputString(
                        String.format(
                                "There are no such answer, choose the digit from 0 to %d",
                                question.getProvidedAnswers().size() - 1)
                );
            }
        }
    }
}
