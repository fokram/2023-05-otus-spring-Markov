package ru.otus.spring.service;

import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class TestSpringBootConfiguration {
    @Bean
    IOService ioService() {
        return Mockito.spy(IOService.class);
    }
}
