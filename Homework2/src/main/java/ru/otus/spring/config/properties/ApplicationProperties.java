package ru.otus.spring.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class ApplicationProperties {
    @Value("${application.config.fileName}")
    private String fileName;

    @Value("${application.config.delimiter}")
    private String delimiter;

    @Value("${application.config.passScore}")
    private int passScore;

    public String getFileName() {
        return fileName;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public int getPassScore() {
        return passScore;
    }
}
