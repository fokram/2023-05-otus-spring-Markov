package ru.otus.spring.service.impl;

import ru.otus.spring.dao.QuestionAndAnswersDao;
import ru.otus.spring.dao.QuestionAndAnswersDaoImpl;
import ru.otus.spring.model.Pair;
import ru.otus.spring.service.QuizService;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class QuizServiceImpl implements QuizService {
    private String resourcePath;

    private QuestionAndAnswersDao questionAndAnswers;

    public List<Pair> getQuiz() {

        URL url = this.getClass().getClassLoader().getResource(resourcePath);

        if (url == null) {
            System.out.println("File not found " + resourcePath);
            return Collections.emptyList();
        }

        List<Pair> pairs = null;
        try {
            pairs = questionAndAnswers.getPairs(Paths.get(url.toURI()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return pairs;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public void setQuestionAndAnswers(QuestionAndAnswersDaoImpl questionAndAnswers) {
        this.questionAndAnswers = questionAndAnswers;
    }
}
