package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.config.AppProperties;
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

    private final AppProperties appProperties;

    public AppRunnerImpl(
            QuestionDao questionDao,
            QuizService quizService,
            UserService userService,
            AppProperties appProperties) {
        this.questionDao = questionDao;
        this.quizService = quizService;
        this.userService = userService;
        this.appProperties = appProperties;
    }

    public void run() {
        User user = userService.processAndGetNewUser();
        List<Question> questions = questionDao.getQuestions();
        var passScore = appProperties.getPassScore();

        Quiz quiz = new Quiz(user, passScore, questions);

        quizService.process(quiz);
    }


}
