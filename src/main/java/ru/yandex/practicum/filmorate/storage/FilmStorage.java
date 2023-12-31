package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.model.Film;

public interface FilmStorage {
    public Film updateFilm(Film film);

    public Film addFilm(Film film);

    public void deleteFilm(int id);
}
