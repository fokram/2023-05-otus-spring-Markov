package ru.otus.spring.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class QuestionDaoCsvTest {
    private final String fileName = "questions.csv";

    private final String delimiter = ";";

    private final QuestionDaoCsv questionDao = new QuestionDaoCsv(fileName, delimiter);

    @Test
    void successfulGetQuestionList() {
        List<Question> questions = questionDao.getQuestions();
        assertTrue(questions.size() > 0);
    }
}