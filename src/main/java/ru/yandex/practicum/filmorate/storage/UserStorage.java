package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.model.User;

public interface UserStorage {

    public User updateUser(User user);

    public User addUser(User user);

    public void deleteUser(int id);

}
