package ru.yandex.practicum.filmorate.dao;

import ru.yandex.practicum.filmorate.model.User;

import java.util.Collection;

public interface UserStorage {

    public User updateUser(User user);

    public User addUser(User user);

    public void deleteUser(int id);

    User getUserById(int id);

    Collection<User> getUsers();

}
