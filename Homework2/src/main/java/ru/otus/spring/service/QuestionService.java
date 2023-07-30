package ru.otus.spring.service;

import ru.otus.spring.model.Question;

public interface QuestionService {
    int processQuestionAndGetScoreIncrement(Question question);
}
