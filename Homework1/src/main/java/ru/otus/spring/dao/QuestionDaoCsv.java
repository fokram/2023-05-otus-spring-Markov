package ru.otus.spring.dao;

import ru.otus.spring.exception.QuestionParseException;
import ru.otus.spring.exception.QuestionReadException;
import ru.otus.spring.model.Question;
import ru.otus.spring.utils.CsvFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDaoCsv implements QuestionDao {
    private final CsvFormatter csvFormatter;

    private final String resourcePath;

    public QuestionDaoCsv(CsvFormatter csvFormatter, String resourcePath) {
        this.csvFormatter = csvFormatter;
        this.resourcePath = resourcePath;
    }

    @Override
    public List<Question> getQuestions() throws QuestionParseException, QuestionReadException {
        List<Question> collect = new ArrayList<>();
        for (String s : getLines()) {
            collect.add(csvFormatter.getQuestion(s));
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
        InputStream result = this.getClass().getClassLoader().getResourceAsStream(resourcePath);

        if (result == null) {
            throw new QuestionReadException(String.format("Wrong file path: %s", resourcePath));
        }

        return result;
    }
}
