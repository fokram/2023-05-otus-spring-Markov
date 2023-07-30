package ru.otus.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;
import ru.otus.spring.model.Quiz;
import ru.otus.spring.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
class QuizFinalizeServiceTest {
    @InjectMocks
    private QuizFinalizeServiceImpl quizFinalizeService;

    @Mock
    private OutputService outputService;

    private Quiz quiz;

    @BeforeEach
    public void setUp() {
        List<Question> questions = List.of(new Question(
                        "question",
                        List.of(new Answer("ans", 1))
                )
        );

        quiz = new Quiz(new User("asdf", "fdsa"), 1, questions);
    }

    @Test
    void successfulProcessQuizFinalize() {
        assertDoesNotThrow(() -> quizFinalizeService.finalizeQuiz(quiz));
    }
}