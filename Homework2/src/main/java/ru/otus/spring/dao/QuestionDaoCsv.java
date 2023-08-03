package ru.otus.spring.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring.config.DaoProperties;
import ru.otus.spring.exception.QuestionReadException;
import ru.otus.spring.model.Question;
import ru.otus.spring.utils.QuestionParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class QuestionDaoCsv implements QuestionDao {
    private final String fileName;

    private final String delimiter;

    private final QuestionParser questionParser;

    public QuestionDaoCsv(QuestionParser questionParser, DaoProperties daoProperties) {
        this.fileName = daoProperties.getFileName();
        this.delimiter = daoProperties.getDelimiter();
        this.questionParser = questionParser;
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> collect = new ArrayList<>();
        for (String s : getLines()) {
            collect.add(questionParser.getQuestion(s, delimiter));
        }

        return collect;
    }

    private List<String> getLines() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getStream()))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            throw new QuestionReadException(e.getMessage(), e);
        }
    }

    private InputStream getStream() {
        return this.getClass().getClassLoader().getResourceAsStream(fileName);
    }
}
