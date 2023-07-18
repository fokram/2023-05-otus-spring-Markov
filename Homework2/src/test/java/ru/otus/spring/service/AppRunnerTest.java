package ru.otus.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring.Main;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = Main.class)
public class AppRunnerTest {

    @Autowired
    IOService ioService;
    @Autowired
    private AppRunner appRunner;

    @Test
    void applicationProcessedSuccessful() {
        when(ioService.readStringWithPrompt(any())).thenReturn("");
        when(ioService.readIntWithPrompt(any())).thenReturn(0);

        assertDoesNotThrow(appRunner::run);
    }
}
