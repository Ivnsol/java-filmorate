package ru.yandex.practicum.filmorate.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.dao.UserStorage;
import ru.yandex.practicum.filmorate.model.User;

import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    @Qualifier("userStorageImpl")
    private final UserStorage userStorage;

    public Collection<User> getUsers() {
        return userStorage.getUsers();
    }

    public User getUserById(int id) {
        return userStorage.getUserById(id);
    }

    public User addUser(User user) {
        log.info("Пользователь {} добавлен", user);
        return userStorage.addUser(user);
    }

    public User updateUser(User user) {
        log.info("Пользователь {} обновлен", user);
        return userStorage.updateUser(user);
    }

    public void deleteUser(int id) {
        userStorage.deleteUser(id);
    }

    public LinkedHashSet<User> getUserFriends(int id) {
        User user = userStorage.getUserById(id);
        Set<Integer> usersId = user.getFriends();
        Set<User> commonFriends = new HashSet<>();
        for (Integer integer : usersId) {
            User users = userStorage.getUserById(integer);
            commonFriends.add(users);
        }
        return commonFriends.stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }


    public Set<User> getCommonFriends(int userId,
                                      int userCommonFriendId) {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(userStorage.getUserById(userId).getFriends());
        numbers.addAll(userStorage.getUserById(userCommonFriendId).getFriends());

        if (!numbers.isEmpty()) {
            Map<Integer, Long> map = numbers
                    .stream()
                    .collect(
                            Collectors
                                    .groupingBy(n -> n, Collectors.counting())
                    );
            Set<Integer> id = map
                    .entrySet()
                    .stream()
                    .filter(e -> e.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());
            Set<User> commonFriends = new HashSet<>();
            for (Integer integer : id) {
                User user = userStorage.getUserById(integer);
                commonFriends.add(user);
            }
            return commonFriends;
        } else {
            return new HashSet<>();
        }
    }

    public void addFriend(int idUser,
                          int newFriendToUserId) {

        User user1 = userStorage.getUserById(idUser);
        User user2 = userStorage.getUserById(newFriendToUserId);

      //  user2.addFriend(idUser);
        user1.addFriendToUser(newFriendToUserId);
        user1.setFriendStatus(newFriendToUserId, "Запрос отправлен");

        updateUser(user1);
    }

    public void deleteFriend(int idUser,
                             int removingFriendId) {

        User user1 = userStorage.getUserById(idUser);
        user1.deleteFriend(removingFriendId);

        updateUser(user1);
    }
}
