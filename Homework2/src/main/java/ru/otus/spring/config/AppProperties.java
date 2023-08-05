package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppProperties {
    private final int passScore;

    public AppProperties(
            @Value("${application.config.passScore}") int passScore) {
        this.passScore = passScore;
    }

    public int getPassScore() {
        return passScore;
    }
}