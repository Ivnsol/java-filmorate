package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/films")
@Slf4j
public class FilmController {
    private final Map<Integer, Film> films = new HashMap<>();
    private int id = 1;

    @GetMapping
    public Collection<Film> getFilms() { //get all films
        return films.values();
    }

    @PostMapping
    public Film addFilm(@Valid @RequestBody Film film) { //add film
        film.setId(id);
        id++;
        log.info("Фильм {} добавлен", film);
        films.put(film.getId(), film);
        return film;
    }

    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film) { //update film
        if (!films.containsKey(film.getId())) {
            throw new IllegalStateException("Не верный id");
        }
        films.put(film.getId(), film);
        log.info("Фильм {} обновлен", film);
        return film;
    }
}
