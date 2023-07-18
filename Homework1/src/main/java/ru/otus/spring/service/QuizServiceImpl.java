package ru.otus.spring.service;

import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.exception.QuestionParseException;
import ru.otus.spring.exception.QuestionReadException;
import ru.otus.spring.model.Question;

import java.util.List;

public class QuizServiceImpl implements QuizService {
    private final QuestionDao questionDao;

    public QuizServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> getQuiz() throws QuestionReadException, QuestionParseException {
        return questionDao.getQuestions();
    }
}
