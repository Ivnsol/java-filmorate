package ru.yandex.practicum.filmorate.controller.validations.dataCheck.after1985;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidatorAfterFirstDate implements ConstraintValidator<AfterFirstDateValidator, LocalDate> {
    @Override
    public void initialize(AfterFirstDateValidator constraintAnnotation) {
        // Ничего не требуется инициализировать
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

        LocalDate minDate = LocalDate.of(1890, 12, 28);
        return !value.isBefore(minDate);
    }
}