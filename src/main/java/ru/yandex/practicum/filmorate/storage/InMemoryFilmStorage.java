package ru.yandex.practicum.filmorate.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/films")
@Slf4j
@Component
public class InMemoryFilmStorage implements FilmStorage {
    private final Map<Integer, Film> films = new ConcurrentHashMap<>();
    private int id = 1;

    public Collection<Film> getFilms() { //get all films
        return films.values();
    }

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
        log.info("Фильм {} добавлен", film);
        films.put(film.getId(), film);
        return film;
    }

    @Override
    public Film updateFilm(Film film) { //update film
        if (!films.containsKey(film.getId())) {
            throw new IllegalStateException("Не верный id");
        }
        films.put(film.getId(), film);
        log.info("Фильм {} обновлен", film);
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

}
