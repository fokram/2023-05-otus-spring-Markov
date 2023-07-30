package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.model.Quiz;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuestionService questionService;

    private final QuizFinalizeService quizFinalizeService;

    public QuizServiceImpl(QuestionService questionService, QuizFinalizeService quizFinalizeService) {
        this.questionService = questionService;
        this.quizFinalizeService = quizFinalizeService;
    }

    @Override
    public void process(Quiz quiz) {
        quiz.getQuestions()
                .forEach(question -> {
                            int increment = questionService.processQuestionAndGetScoreIncrement(question);
                            quiz.incScore(increment);
                        }
                );

        quizFinalizeService.finalizeQuiz(quiz);
    }
}
