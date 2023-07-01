package ru.otus.spring.utils;

import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFormatter {
    private final String delimeter;

    public CsvFormatter(String delimeter) {
        this.delimeter = delimeter;
    }

    public Question getQuestion(String line) {
        List<String> splittedLine = Arrays.asList(line.split(delimeter));

        String question = splittedLine.get(0);
        String correctAnswer = splittedLine.get(1);
        List<Answer> answers = splittedLine.subList(2, splittedLine.size()).stream()
                .map(answer -> new Answer(answer, answer.equals(correctAnswer)))
                .collect(Collectors.toList());

        return new Question(question, answers);
    }
}
