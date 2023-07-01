package ru.otus.spring.service;


import ru.otus.spring.model.Question;

import java.io.PrintStream;

public class OutputServiceImpl implements OutputService {
    private final PrintStream output;

    public OutputServiceImpl(PrintStream outputStream) {
        output = outputStream;
    }

    @Override
    public void outputQuestion(Question question) {
        output.println("The question is: " + question.getQuestionText());
        output.println("Below you will find answers:");
        question.getAnswers()
                .forEach(answer -> output.println(answer.getAnswerText()));
    }

    @Override
    public void outputString(String string) {
        output.println(string);
    }
}
