package ru.yandex.practicum.filmorate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.InMemoryFilmStorage;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmService {
    private final InMemoryFilmStorage inMemoryFilmStorage;


    public void addLikeToFilm(int filmId, int userId) {
        Film film = inMemoryFilmStorage.getFilmById(filmId);
        film.setLikes(userId);
    }

    public void removeLikeFromFilm(int filmId, int userId) {
        Film film = inMemoryFilmStorage.getFilmById(filmId);
        film.deleteLike(userId);
    }

    public Collection<Film> getTopFilms(int count) {
        return inMemoryFilmStorage.getFilms().stream()
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> {
                    int amountOfLikes1 = o1.getUserWhoLikeIds().size();
                    int amountOfLikes2 = o2.getUserWhoLikeIds().size();
                    return Integer.compare(amountOfLikes2, amountOfLikes1);
                })
                .limit(count)
                .collect(Collectors.toList());
}


    public Collection<Film> getFilms() {
        return inMemoryFilmStorage.getFilms();
    }

    public Film getFilmById(int id) {
        return inMemoryFilmStorage.getFilmById(id);
    }

    public Film addFilm(Film film) { //add film
        return inMemoryFilmStorage.addFilm(film);
    }

    public Film updateFilm(Film film) { //update film
        return inMemoryFilmStorage.updateFilm(film);
    }

    public void deleteFilm(int id) {
        inMemoryFilmStorage.deleteFilm(id);
    }
}
