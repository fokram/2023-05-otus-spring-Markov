package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;
import ru.otus.spring.model.Quiz;
import ru.otus.spring.model.User;

@Service
public class QuizService {
    private final IOService ioService;

    public QuizService(IOService ioService) {
        this.ioService = ioService;
    }

    public void process(Quiz quiz) {
        quiz.getQuestions()
                .forEach(question -> {
                            quiz.incScore(
                                    processQuestionAndGetScoreIncrement(question)
                            );
                        }
                );
    }

    public User processUser() {
        return new User(
                ioService.readStringWithPrompt("Enter your first name: "),
                ioService.readStringWithPrompt("Enter your last name: ")
        );
    }

    public void finalizeQuiz(Quiz quiz) {
        if (quiz.isPassQuiz() == 1) {
            ioService.outputString(String.format("Dear %s, you have passed the Test", quiz.getUser().getFullName()));
        } else {
            ioService.outputString(String.format("Dear %s, you haven't passed the Test", quiz.getUser().getFullName()));
        }
        ioService.outputString(
                String.format("Count correct answer is %d", quiz.getScore())
        );
        ioService.outputString(
                String.format("Count incorrect answer is %d", quiz.getQuestions().size() - quiz.getScore())
        );
    }


    private int processQuestionAndGetScoreIncrement(Question question) {
        ioService.outputString(question.getQuestionText());
        ioService.outputString("Choose one correct answer provided below");

        question.getProvidedAnswers().stream()
                .map(Answer::getAnswerText)
                .forEach(ioService::outputString);

        return getAnswerGetScoreIncrement(question);
    }

    private int getAnswerGetScoreIncrement(Question question) {
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
