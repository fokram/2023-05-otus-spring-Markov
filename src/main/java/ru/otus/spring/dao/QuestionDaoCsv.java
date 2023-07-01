package ru.otus.spring.dao;

import ru.otus.spring.exception.QuestionException;
import ru.otus.spring.model.Question;
import ru.otus.spring.utils.CsvFormatter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionDaoCsv implements QuestionDao {
    private final CsvFormatter csvFormatter;

    private final String resourcePath;

    public QuestionDaoCsv(CsvFormatter csvFormatter, String resourcePath) {
        this.csvFormatter = csvFormatter;
        this.resourcePath = resourcePath;
    }

    @Override
    public List<Question> getQuestion() throws QuestionException {
        return getLines()
                .map(csvFormatter::getQuestion)
                .collect(Collectors.toList());
    }

    private Stream<String> getLines() throws QuestionException {
        return new BufferedReader(new InputStreamReader(getStream())).lines();
    }

    private InputStream getStream() throws QuestionException {
        InputStream result = this
                .getClass()
                .getClassLoader()
                .getResourceAsStream(resourcePath);

        if (result == null) {
            throw new QuestionException("Wrong file path", resourcePath);
        }

        return result;
    }
}
