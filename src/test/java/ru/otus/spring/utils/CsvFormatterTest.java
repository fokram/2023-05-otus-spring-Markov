package ru.otus.spring.utils;

import org.junit.jupiter.api.Test;
import ru.otus.spring.exception.QuestionParseException;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class CsvFormatterTest {
    private final CsvFormatter csvFormatter = new CsvFormatter(";");

    @Test
    void successfullyGetQuestion() {
        String sourceLine = "question123;ans1;ans1;ans2";
        Question question;
        try {
            question = csvFormatter.getQuestion(sourceLine);
        } catch (QuestionParseException e) {
            throw new RuntimeException(e);
        }

        List<Answer> expectedAnswers = List.of(new Answer("ans1"), new Answer("ans2"));
        Question expectedQuestion = new Question("question123", expectedAnswers, "ans1");

        assertEquals(expectedQuestion, question);
    }

    @Test
    void throwAnExceptionDuringGettingTheQuestion() {
        String sourceLine = " ; ";
        try {
            csvFormatter.getQuestion(sourceLine);
        } catch (QuestionParseException e) {
            assertNotNull(e.getMessage());
        }
    }
}