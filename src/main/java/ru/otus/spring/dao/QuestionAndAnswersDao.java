package ru.otus.spring.dao;

import ru.otus.spring.model.Pair;

import java.nio.file.Path;
import java.util.List;

public interface QuestionAndAnswersDao {
    List<Pair> getPairs(Path filePath);
}
