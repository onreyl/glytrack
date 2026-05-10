package io.github.onreyl.glytrack.domain.model;

public sealed interface FoodSource permits CatalogFood, ManualFood {
    double grams();

    double carbs();

    double protein();

    double calories();

    int gi();

    String displayName();

    default double glycemicLoad() {
        return (gi() * carbs()) / 100.0;
    }
}