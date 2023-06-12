package ru.otus.spring.service.impl;


import ru.otus.spring.model.Pair;
import ru.otus.spring.service.PrintService;

public class PrintServiceImpl implements PrintService {
    @Override
    public void print(Pair pair) {
        System.out.println("The question is: " + pair.getQuestion());
        System.out.println("Below you will find answers:");
        pair.getAnswers().getAnswers().stream().forEach(System.out::println);
        System.out.println("");
    }
}
