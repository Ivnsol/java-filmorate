package ru.yandex.practicum.filmorate.exeption;

import lombok.Data;

@Data
public class ErrorResponse {
    private String error;
    private String description;
}
