package ru.yandex.practicum.filmorate.dao;

import ru.yandex.practicum.filmorate.model.User;

import java.util.Collection;
import java.util.Set;

public interface UserStorage {

    public User update(User user);

    public User add(User user);

    public void delete(int id);

    User getById(int id);

    Collection<User> get();

    Set<User> getCommonFriends(Set<Integer> id);
}
