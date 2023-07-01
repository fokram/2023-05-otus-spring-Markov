package ru.otus.spring.service;

import ru.otus.spring.exception.QuestionException;
import ru.otus.spring.model.Question;

import java.util.List;

public interface QuizService {
    List<Question> getQuiz() throws QuestionException;
}
