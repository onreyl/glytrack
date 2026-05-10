package io.github.onreyl.glytrack.domain.model;

public record ManualFood(
        String name,
        double grams,
        double carbs,
        double protein,
        double calories,
        int gi
) implements FoodSource {

    public ManualFood {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name boş olamaz");
        }
        if (grams <= 0 || carbs < 0 || protein < 0 || calories < 0) {
            throw new IllegalArgumentException("Değerler geçerli aralıkta olmalı");
        }
        if (gi < 0 || gi > 100) {
            throw new IllegalArgumentException("GI 0-100 arasında olmalı");
        }
    }

    @Override
    public String displayName() {
        return name;
    }
}