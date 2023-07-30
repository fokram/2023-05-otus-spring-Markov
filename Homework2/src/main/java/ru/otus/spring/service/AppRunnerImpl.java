package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.model.Question;
import ru.otus.spring.model.Quiz;
import ru.otus.spring.model.User;

import java.util.List;

@Service
public class AppRunnerImpl implements AppRunner {
    private final QuestionDao questionDao;

    private final QuizService quizService;

    private final UserService userService;

    @Value("${application.config.passScore}")
    private int passScore;

    public AppRunnerImpl(
            QuestionDao questionDao,
            QuizService quizService,
            UserService userService) {
        this.questionDao = questionDao;
        this.quizService = quizService;
        this.userService = userService;
    }

    public void run() {
        User user = userService.processAndGetNewUser();

        List<Question> questions = questionDao.getQuestions();

        Quiz quiz = new Quiz(user, passScore, questions);

        quizService.process(quiz);
    }


}
