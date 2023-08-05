package ru.otus.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {
    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private IOService ioService;

    @Test
    void processQuestionAndGetScoreIncrement() {
        List<Answer> providedAnswers = List.of(new Answer("ans", 1));
        Question question = new Question("question1", providedAnswers);

        doNothing().when(ioService).outputString(any());
        when(ioService.readIntWithPrompt(any())).thenReturn(0);

        int increment = questionService.processQuestionAndGetScoreIncrement(question);

        assertEquals(1, increment);
    }
}