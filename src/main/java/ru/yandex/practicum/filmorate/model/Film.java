package ru.yandex.practicum.filmorate.model;


import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;
import ru.yandex.practicum.filmorate.controller.validations.dataCheck.after1985.AfterFirstDateValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Validated
@Data
public class Film {
    private int id;
    @NotNull
    @NotBlank
    private final String name;
    @Size(max = 200)
    private final String description;
    @AfterFirstDateValidator
    private final LocalDate releaseDate;
    @Positive
    private final int duration;

    public Film(String name, String description, LocalDate releaseDate, int duration) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                '}';
    }
}
