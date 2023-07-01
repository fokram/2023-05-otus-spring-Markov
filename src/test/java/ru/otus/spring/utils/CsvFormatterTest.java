package ru.otus.spring.utils;

import org.junit.jupiter.api.Test;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CsvFormatterTest {
    private final CsvFormatter csvFormatter = new CsvFormatter(";");

    @Test
    void getQuestion() {
        String sourceLine = "question123;ans1;ans1;ans2";
        Question question = csvFormatter.getQuestion(sourceLine);

        List<Answer> expectedAnswers = List.of(new Answer("ans1", true), new Answer("ans2", false));
        Question expectedQuestion = new Question("question123", expectedAnswers);

        assertEquals(expectedQuestion, question);
    }
}