package ru.otus.spring.utils;

import org.junit.jupiter.api.Test;
import ru.otus.spring.exception.QuestionParseException;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuestionParserTest {
    private final String delimiter = ";";

    private final QuestionParser questionParser = new QuestionParser();

    @Test
    void successfullyGetQuestion() {
        String sourceLine = "question123;ans1;ans1;ans2";
        Question question = questionParser.getQuestion(sourceLine, delimiter);

        List<Answer> expectedAnswers = List.of(new Answer("ans1", 1), new Answer("ans2", 0));
        Question expectedQuestion = new Question("question123", expectedAnswers);

        assertEquals(expectedQuestion, question);
    }

    @Test
    void throwAnExceptionDuringGettingTheQuestion() {
        String sourceLine = " ; ";
        try {
            questionParser.getQuestion(sourceLine, delimiter);
        } catch (QuestionParseException e) {
            assertNotNull(e.getMessage());
        }
    }
}