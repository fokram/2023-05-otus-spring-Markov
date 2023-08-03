package ru.otus.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.config.AppProperties;
import ru.otus.spring.dao.QuestionDaoCsv;
import ru.otus.spring.model.User;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppRunnerTest {
    private final User user = new User(" ", " ");
    @InjectMocks
    private AppRunnerImpl appRunner;
    @Mock
    private QuestionDaoCsv questionDao;
    @Mock
    private QuizServiceImpl quizService;
    @Mock
    private UserService userService;
    @Mock
    private AppProperties appProperties;

    @Test
    void applicationProcessedSuccessful() {
        when(userService.processAndGetNewUser()).thenReturn(user);
        when(appProperties.getPassScore()).thenReturn(3);

        assertDoesNotThrow(appRunner::run);
    }
}
