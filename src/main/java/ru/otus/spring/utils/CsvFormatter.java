package ru.otus.spring.utils;

import ru.otus.spring.exception.QuestionParseException;
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

    public Question getQuestion(String line) throws QuestionParseException {
        List<String> splittedLine = getSplitedLine(line);

        String question = splittedLine.get(0);
        String correctAnswerText = splittedLine.get(1);
        List<Answer> answers = splittedLine.subList(2, splittedLine.size()).stream()
                .map(Answer::new)
                .collect(Collectors.toList());

        return new Question(question, answers, correctAnswerText);
    }

    private List<String> getSplitedLine(String line) throws QuestionParseException {
        List<String> splittedLine = Arrays.asList(line.split(delimeter));
        validateFormat(splittedLine);

        return Arrays.asList(line.split(delimeter));
    }

    private void validateFormat(List<String> splittedLine) throws QuestionParseException {
        if (splittedLine.size() <= 2) {
            throw new QuestionParseException(
                    String.format("Format line doesn't support. [splittedLine.size() = %s]", splittedLine.size())
            );
        }
    }
}
