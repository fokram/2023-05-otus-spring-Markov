package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.model.User;

@Service
public class UserServiceImpl implements UserService {

    private final InputService inputService;

    public UserServiceImpl(InputService inputService) {
        this.inputService = inputService;
    }

    @Override
    public User processAndGetNewUser() {
        String firstName = inputService.readStringWithPrompt("Enter your first name: ");
        String lastName = inputService.readStringWithPrompt("Enter your last name: ");

        return new User(firstName, lastName);
    }
}
