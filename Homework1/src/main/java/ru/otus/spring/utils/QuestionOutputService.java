package ru.otus.spring.utils;

import ru.otus.spring.model.Question;

public class QuestionOutputService {
    public static String getOutputString(Question question) {
        StringBuilder result = new StringBuilder();

        result.append(String.format("The question is: %s \n", question.getQuestionText()));

        result.append("Choose a correct answer:\n");

        question.getAnswers().forEach(answer -> result
                .append(answer.getAnswerText())
                .append("\n")
        );

        return result.toString();
    }
}
