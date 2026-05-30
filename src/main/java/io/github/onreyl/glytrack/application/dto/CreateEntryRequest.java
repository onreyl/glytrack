package io.github.onreyl.glytrack.application.dto;

import io.github.onreyl.glytrack.domain.model.MealType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CreateEntryRequest(

        @NotNull(message = "date zorunlu")
        LocalDate date,

        MealType mealType,

        @NotNull @Positive(message = "grams pozitif olmalı")
        Double grams,

        Long foodId,

        String manualName,
        @PositiveOrZero Double manualCarbs,
        @PositiveOrZero Double manualProtein,
        @PositiveOrZero Double manualCalories,
        @Min(0) @Max(100) Integer manualGi
) {
}
