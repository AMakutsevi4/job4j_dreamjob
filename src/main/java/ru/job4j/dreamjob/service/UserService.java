package ru.job4j.dreamjob.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.User;
import ru.job4j.dreamjob.persistence.UserDbStore;

import java.util.Optional;

@Service
public class UserService {

    private final UserDbStore store;

    public UserService(UserDbStore store) {
        this.store = store;
    }

    public Optional<User> add(User user) {
        return store.add(user);
    }
}
