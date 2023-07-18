package ru.otus.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.dao.QuestionDaoCsv;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;
import ru.otus.spring.model.Quiz;
import ru.otus.spring.model.User;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {
    @InjectMocks
    QuizService quizService;

    @Mock
    IOService ioService;

    @Mock
    QuestionDaoCsv questionDao;

    @Test
    void processQuizSuccessfulFinish() {
        when(ioService.readIntWithPrompt(any())).thenReturn(0);
        when(questionDao.getQuestions()).thenReturn(
                List.of(new Question(
                                "question",
                                List.of(new Answer("ans", 1))
                        )
                )
        );

        Quiz quiz = new Quiz(new User("asdf", "fdsa"), 1, questionDao.getQuestions());
        quizService.process(quiz);

        assertEquals(1, quiz.getScore());
        assertEquals(1, quiz.isPassQuiz());
    }

    @Test
    void processUserSuccessfulFinished() {
        when(ioService.readStringWithPrompt(any())).thenReturn("");
        User user = quizService.processUser();
        assertNotNull(user);
    }
}
