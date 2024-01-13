package ru.yandex.practicum.filmorate.dao;

import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;
import java.util.List;

public interface FilmStorage {
    Film updateFilm(Film film);

    Film addFilm(Film film);

    void deleteFilm(int id);

    Film getFilmById(int id);

    Collection<Film> getFilms();

    Collection<Film> getTopFilms(int count);

    Film.GenreWrapper getGenreById(int id);

    List<Film.GenreWrapper> getGenre();

    List<Film.MpaWrapper> getMpa();

    Film.MpaWrapper getMpaById(int id);
}
