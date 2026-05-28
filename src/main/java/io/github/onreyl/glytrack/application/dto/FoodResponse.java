package io.github.onreyl.glytrack.application.dto;

public record FoodResponse(
        Long id,
        String name,
        double carbsPer100g,
        double proteinPer100g,
        double caloriesPer100g,
        int gi
) {
}