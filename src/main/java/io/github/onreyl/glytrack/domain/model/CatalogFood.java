package io.github.onreyl.glytrack.domain.model;

public record CatalogFood(Food food, double grams) implements FoodSource {

    public CatalogFood {
        if (food == null) {
            throw new IllegalArgumentException("Food boş olamaz");
        }
        if (grams <= 0) {
            throw new IllegalArgumentException("Grams pozitif olmalı");
        }
    }

    @Override
    public double carbs() {
        return (food.carbsPer100g() * grams) / 100.0;
    }

    @Override
    public double protein() {
        return (food.proteinPer100g() * grams) / 100.0;
    }

    @Override
    public double calories() {
        return (food.caloriesPer100g() * grams) / 100.0;
    }

    @Override
    public int gi() {
        return food.gi();
    }

    @Override
    public String displayName() {
        return food.name();
    }
}