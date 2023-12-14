package ru.yandex.practicum.filmorate.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class InMemoryUserStorage implements UserStorage {
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private int id = 1;

    public Collection<User> getUsers() { //get all films
        return users.values();
    }

    public User getUserById(int id) {
        if (!users.containsKey(id)) throw new IllegalArgumentException("не верный аргумент");
        return users.get(id);
    }

    @Override
    public User addUser(User user) {
        user.setId(id);
        id++;

        users.put(user.getId(), defaultUserName(user));
        log.info("Пользователь {} добавлен", user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        if (!users.containsKey(user.getId())) {
            throw new IllegalStateException("Не верный id");
        }
        users.put(user.getId(), defaultUserName(user));
        log.info("Пользователь {} обновлен", user);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        if (id > 0) {
            users.remove(id);
        } else {
            throw new IllegalStateException("не верное значение");
        }
    }

    public User defaultUserName(User user) {
        if (user.getName() == null ||
                user.getName().equals("")) {
            user.setName(user.getLogin());
            return user;
        }
        return user;
    }
}