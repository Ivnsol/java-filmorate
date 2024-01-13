package ru.yandex.practicum.filmorate.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.yandex.practicum.filmorate.dao.FilmStorage;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FilmService {

    @Qualifier("filmStorageImpl")
    private final FilmStorage filmStorage;

    public List<Film.MpaWrapper> getMpa() {
        return filmStorage.getMpa();
    }

    public Film.MpaWrapper getMpaById(int id) {
        return filmStorage.getMpaById(id);
    }

    public List<Film.GenreWrapper> getGenre() {
        return filmStorage.getGenre();
    }

    public Film.GenreWrapper getGenreById(int id) {
        return filmStorage.getGenreById(id);
    }

    public void addLikeToFilm(int filmId, int userId) {
        Film film = filmStorage.getFilmById(filmId);
        film.setLikes(userId);
        updateFilm(film);
    }

    public void removeLikeFromFilm(int filmId, int userId) {
        Film film = filmStorage.getFilmById(filmId);
        film.deleteLike(userId);
        updateFilm(film);
    }

    public Collection<Film> getTopFilms(int count) {
        return filmStorage.getTopFilms(count);
    }


    public Collection<Film> getFilms() {
        return filmStorage.getFilms();
    }

    public Film getFilmById(int id) {
        return filmStorage.getFilmById(id);
    }

    public Film addFilm(Film film) { //add film
        log.info("Фильм {} добавлен", film);
        return filmStorage.addFilm(film);
    }

    public Film updateFilm(Film film) { //update film
        log.info("Фильм {} обновлен", film);
        return filmStorage.updateFilm(film);
    }

    public void deleteFilm(int id) {
        filmStorage.deleteFilm(id);
    }
}
