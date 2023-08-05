package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.model.Quiz;

@Service
public interface QuizService {
    void process(Quiz quiz);
}
