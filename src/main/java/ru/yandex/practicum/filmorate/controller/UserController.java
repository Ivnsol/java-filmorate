package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final Map<Integer, User> users = new HashMap<>();
    private int id = 1;

    @GetMapping
    public Collection<User> getFilms() { //get all films
        return users.values();
    }

    @PostMapping
    public User addUser(@Valid @RequestBody User user) {
        user.setId(id);
        id++;

        users.put(user.getId(), user);
        log.info("Пользователь {} добавлен", user);
        return user;
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) {
        if (!users.containsKey(user.getId())) {
            throw new IllegalStateException("Не верный id");
        }
        users.put(user.getId(), user);
        log.info("Пользователь {} обновлен", user);
        return user;
    }

}
