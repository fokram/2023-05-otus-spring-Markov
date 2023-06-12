package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.PrintService;
import ru.otus.spring.service.QuizService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuizService quizService = context.getBean(QuizService.class);
        PrintService printService = context.getBean(PrintService.class);

        quizService.getQuiz().forEach(printService::print);
    }
}
