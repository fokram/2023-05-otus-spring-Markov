package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.config.properties.ApplicationProperties;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.model.Quiz;

@Service
public class AppRunnerImpl implements AppRunner {
    private final QuestionDao questionDao;

    private final QuizService quizService;

    private final int passScore;

    public AppRunnerImpl(
            QuestionDao questionDao,
            QuizService quizService,
            ApplicationProperties applicationProperties) {
        this.questionDao = questionDao;
        this.quizService = quizService;
        this.passScore = applicationProperties.getPassScore();
    }

    public void run() {
        Quiz quiz = new Quiz(quizService.processUser(), passScore, questionDao.getQuestions());

        quizService.process(quiz);

        quizService.finalizeQuiz(quiz);
    }


}
