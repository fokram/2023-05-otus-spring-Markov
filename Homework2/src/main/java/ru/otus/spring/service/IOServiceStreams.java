package ru.otus.spring.service;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceStreams implements IOService {
    private final PrintStream output;

    private final Scanner input;

    public IOServiceStreams() {
        output = System.out;
        input = new Scanner(System.in);
    }

//    не соображу как заинжектить System.out/System.in, подскажите плз

//    public IOServiceStreams(PrintStream outputStream, InputStream inputStream) {
//        output = outputStream;
//        input = new Scanner(inputStream);
//    }

    @Override
    public void outputString(String s) {
        output.println(s);
    }

    @Override
    public int readInt() {
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public int readIntWithPrompt(String prompt) {
        outputString(prompt);
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public String readStringWithPrompt(String prompt) {
        outputString(prompt);
        return input.nextLine();
    }
}
