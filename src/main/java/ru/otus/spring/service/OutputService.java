package ru.otus.spring.service;

import ru.otus.spring.model.Question;

public interface OutputService {
    void outputQuestion(Question question);

    void outputString(String string);
}
