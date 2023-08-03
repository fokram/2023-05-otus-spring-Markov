package ru.otus.spring.dao;

import org.junit.jupiter.api.Test;
import ru.otus.spring.config.DaoProperties;
import ru.otus.spring.model.Question;
import ru.otus.spring.utils.QuestionParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionDaoCsvTest {
    private final QuestionParser questionParser = new QuestionParser();

    private final DaoProperties daoProperties = new DaoProperties("questions.csv", ";");

    private final QuestionDaoCsv questionDao = new QuestionDaoCsv(questionParser, daoProperties);

    @Test
    void successfulGetQuestionList() {
        List<Question> questions = questionDao.getQuestions();
        assertTrue(questions.size() > 0);
    }
}