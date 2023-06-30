package ru.otus.spring.utils;

import ru.otus.spring.model.AnswerEntity;
import ru.otus.spring.model.Pair;
import ru.otus.spring.model.Question;

import java.util.Arrays;
import java.util.List;

public class PairFormatter {

    public static Pair getPair(String line, String delimeter) {
        Question question;
        AnswerEntity answer;

        List<String> splittedStringLine = Arrays.asList(line.split(delimeter));

        if ( !splittedStringLine.isEmpty() ) {
            question = new Question(splittedStringLine.get(0));
        } else {
            question = null;
        }

        if ( splittedStringLine.size() >= 2 ) {
            answer = new AnswerEntity(splittedStringLine.subList(1, splittedStringLine.size()));
        } else {
            answer = null;
        }

        return new Pair(answer, question);
    }
}
