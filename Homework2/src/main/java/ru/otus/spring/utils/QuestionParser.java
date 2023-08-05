package ru.otus.spring.utils;

import org.springframework.stereotype.Component;
import ru.otus.spring.exception.QuestionParseException;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionParser {
    public Question getQuestion(String line, String delimiter) throws QuestionParseException {
        List<String> splitLine = getSplitLine(line, delimiter);

        String question = splitLine.get(0);
        String correctAnswerText = splitLine.get(1);
        List<Answer> answers = splitLine.subList(2, splitLine.size()).stream()
                .map(answerText -> new Answer(answerText, answerText.equals(correctAnswerText) ? 1 : 0))
                .collect(Collectors.toList());

        return new Question(question, answers);
    }

    private List<String> getSplitLine(String line, String delimiter) throws QuestionParseException {
        List<String> splitLine = Arrays.asList(line.split(delimiter));
        validateFormat(splitLine);

        return Arrays.asList(line.split(delimiter));
    }

    private void validateFormat(List<String> splitLine) throws QuestionParseException {
        if (splitLine.size() <= 2) {
            throw new QuestionParseException(
                    String.format("Format line doesn't support. [splitLine.size() = %s]", splitLine.size())
            );
        }
    }
}
