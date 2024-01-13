package ru.yandex.practicum.filmorate.storage;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.dao.FilmStorage;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
@Component
public class InMemoryFilmStorage implements FilmStorage {
    private final Map<Integer, Film> films = new ConcurrentHashMap<>();
    private int id = 1;

    @Override
    public Collection<Film> getFilms() { //get all films
        return films.values();
    }

    @Override
    public Film getFilmById(int id) {
        if (!films.containsKey(id)) {
            throw new IllegalArgumentException("Не верный id фильма");
        }
        return films.get(id);
    }

    @Override
    public Film addFilm(Film film) { //add film
        film.setId(id);
        id++;
        films.put(film.getId(), film);
        return film;
    }

    @Override
    public Film updateFilm(Film film) { //update film
        if (!films.containsKey(film.getId())) {
            throw new IllegalStateException("Не верный id");
        }
        films.put(film.getId(), film);
        return film;
    }


    @Override
    public void deleteFilm(int id) {
        if (id > 0) {
            films.remove(id);
        } else {
            throw new IllegalStateException("не верное значение");
        }
    }

    public Collection<Film> getTopFilms(int count) {
        return getFilms().stream()
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> {
                    int amountOfLikes1 = o1.getUserWhoLikeIds().size();
                    int amountOfLikes2 = o2.getUserWhoLikeIds().size();
                    return Integer.compare(amountOfLikes2, amountOfLikes1);
                })
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Film.GenreWrapper getGenreById(int id) {
        return null;
    }

    @Override
    public List<Film.GenreWrapper> getGenre() {
        return null;
    }

    @Override
    public List<Film.MpaWrapper> getMpa() {
        return null;
    }

    @Override
    public Film.MpaWrapper getMpaById(int id) {
        return null;
    }

}
