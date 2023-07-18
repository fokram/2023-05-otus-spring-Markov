package ru.otus.spring.service;

import java.io.PrintStream;

public class OutputServiceImpl implements OutputService {
    private final PrintStream output;

    public OutputServiceImpl(PrintStream outputStream) {
        output = outputStream;
    }

    @Override
    public void outputString(String string) {
        output.println(string);
    }
}
