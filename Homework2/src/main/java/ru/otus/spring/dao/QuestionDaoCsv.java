package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.otus.spring.exception.QuestionReadException;
import ru.otus.spring.model.Question;
import ru.otus.spring.utils.QuestionParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class QuestionDaoCsv implements QuestionDao {
    private final String fileName;

    private final String delimiter;

    public QuestionDaoCsv(
            @Value("${application.config.fileName}") String fileName,
            @Value("${application.config.delimiter}") String delimiter) {
        this.fileName = fileName;
        this.delimiter = delimiter;
    }

    @Override
    public List<Question> getQuestions() throws QuestionReadException {
        List<Question> collect = new ArrayList<>();
        for (String s : getLines()) {
            collect.add(QuestionParser.getQuestion(s, delimiter));
        }

        return collect;
    }

    private List<String> getLines() throws QuestionReadException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getStream()))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new QuestionReadException(e.getMessage());
        }
    }

    private InputStream getStream() throws QuestionReadException {
        InputStream result = this.getClass().getClassLoader().getResourceAsStream(fileName);

        if (result == null) {
            throw new QuestionReadException(String.format("Wrong file path: %s", fileName));
        }

        return result;
    }
}
