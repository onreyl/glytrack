package io.github.onreyl.glytrack.application.dto;

import io.github.onreyl.glytrack.domain.model.MealType;

import java.time.LocalDate;

public record EntryResponse(
        Long id,
        LocalDate date,
        MealType mealType,        // null
        String foodName,
        double grams,
        double carbs,
        double protein,
        double calories,
        int gi,
        double glycemicLoad
) {
}
