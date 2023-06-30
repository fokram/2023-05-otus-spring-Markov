package ru.otus.spring.utils;

import org.junit.jupiter.api.Test;
import ru.otus.spring.model.AnswerEntity;
import ru.otus.spring.model.Pair;
import ru.otus.spring.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairFormatterTest {

    @Test
    void getPair() {
        AnswerEntity expectedAnswers = new AnswerEntity(List.of("ans1", "ans2"));
        Question expectedQuestion = new Question("question123");
        Pair pair = PairFormatter.getPair("question123;ans1;ans2", ";");

        assertEquals(expectedAnswers, pair.getAnswers());
        assertEquals(expectedQuestion, pair.getQuestion());
    }
}