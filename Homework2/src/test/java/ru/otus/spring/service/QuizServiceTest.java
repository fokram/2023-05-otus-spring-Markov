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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {
    @InjectMocks
    private QuizServiceImpl quizService;

    @Mock
    private QuestionService questionService;

    @Mock
    private QuizFinalizeService quizFinalizeService;

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
    void processQuizSuccessfulFinish() {
        when(questionService.processQuestionAndGetScoreIncrement(any())).thenReturn(1);
        doNothing().when(quizFinalizeService).finalizeQuiz(any());

        quizService.process(quiz);

        assertEquals(1, quiz.getScore());
        assertEquals(1, quiz.isPassQuiz());
    }
}
