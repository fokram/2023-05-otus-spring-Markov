package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoProperties {
    private final String fileName;

    private final String delimiter;

    public DaoProperties(
            @Value("${dao.config.fileName}") String fileName,
            @Value("${dao.config.delimiter}") String delimiter) {
        this.fileName = fileName;
        this.delimiter = delimiter;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDelimiter() {
        return delimiter;
    }
}