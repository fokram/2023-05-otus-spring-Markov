package ru.otus.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.service.IOServiceStreams;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    @Bean
    IOServiceStreams ioServiceStreams() {
        return new IOServiceStreams(
                System.out,
                System.in);
    }
}