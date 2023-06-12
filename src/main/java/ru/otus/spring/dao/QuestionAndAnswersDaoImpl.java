package ru.otus.spring.dao;

import ru.otus.spring.utils.PairFormatter;
import ru.otus.spring.model.Pair;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionAndAnswersDaoImpl implements QuestionAndAnswersDao {
    private String delimiter;

    @Override
    public List<Pair> getPairs(Path filePath) {
        List<Pair> result = new ArrayList();

        try {
            result = Files.readAllLines(filePath, StandardCharsets.UTF_8)
                    .stream()
                    .map(line-> PairFormatter.getPair(line, delimiter))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
