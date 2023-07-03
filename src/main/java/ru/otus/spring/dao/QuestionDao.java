package ru.otus.spring.dao;

import ru.otus.spring.exception.QuestionParseException;
import ru.otus.spring.exception.QuestionReadException;
import ru.otus.spring.model.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions() throws QuestionReadException, QuestionParseException;
}
