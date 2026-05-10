package io.github.onreyl.glytrack.domain.model;

public record Food(
        Long id,
        String name,
        double carbsPer100g,
        double proteinPer100g,
        double caloriesPer100g,
        int gi
) {
    public Food {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Food name boş olamaz");
        }
        if (carbsPer100g < 0 || proteinPer100g < 0 || caloriesPer100g < 0) {
            throw new IllegalArgumentException("Besin değerleri negatif olamaz");
        }
        if (gi < 0 || gi > 100) {
            throw new IllegalArgumentException("GI 0-100 arasında olmalı");
        }
    }
}