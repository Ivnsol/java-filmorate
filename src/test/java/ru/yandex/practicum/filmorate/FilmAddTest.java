package ru.yandex.practicum.filmorate;


import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.FilmService;
import ru.yandex.practicum.filmorate.service.UserService;
import ru.yandex.practicum.filmorate.storage.InMemoryFilmStorage;
import ru.yandex.practicum.filmorate.storage.InMemoryUserStorage;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.*;

public class FilmAddTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void addExtremeNameFilmsTest() {
        Film film = new Film(
                null,
                "Description1",
                LocalDate.of(1999, 4, 22),
                100);

        Set<ConstraintViolation<Film>> violations = validator.validate(film);
        assertEquals(1,violations.size());
    }

    @Test
    public void addExtremeYearFilmsTest() {
        Film film = new Film(
                "Film1",
                "Description1",
                LocalDate.of(1800, 4, 22),
                100);

        Set<ConstraintViolation<Film>> violations = validator.validate(film);
        assertEquals(1,violations.size());
    }

    @Test
    public void addExtremeDurationFilmsTest() {
        Film film = new Film(
                "Film1",
                "Description1",
                LocalDate.of(1999, 4, 22),
                -100);

        Set<ConstraintViolation<Film>> violations = validator.validate(film);
        assertEquals(1,violations.size());
    }

//    @Test
//    public void addLikeToFilmShouldAddUserToLikesList() {
//        Film film = new Film(
//                "Film1",
//                "Description1",
//                LocalDate.of(1999, 4, 22),
//                100);
//        Film film2 = new Film(
//                "Film2",
//                "Description2",
//                LocalDate.of(1999, 4, 22),
//                100);
//        User user = new User(
//                "wq@mail.ru",
//                "Ivan_Ivanovich",
//                "Ivan",
//                LocalDate.of(2000, 2, 22));
//        User user2 = new User(
//                "qw@mail.ru",
//                "IV",
//                "Ivan",
//                LocalDate.of(2000, 2, 22));
//
//        InMemoryFilmStorage inMemoryFilmStorage = new InMemoryFilmStorage();
//        FilmService filmService = new FilmService(inMemoryFilmStorage);
//
//        InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
//        UserService userService = new UserService(inMemoryUserStorage);
//        userService.addUser(user);
//        userService.addUser(user2);
//
//        filmService.addFilm(film);
//        filmService.addFilm(film2);
//
//        // Act
//        filmService.addLikeToFilm(film.getId(), user2.getId());
//        filmService.addLikeToFilm(film.getId(), user.getId());
//        // Assert
//        assertEquals(filmService.getTopFilms(1), film);
//
//    }
}