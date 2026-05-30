package io.github.onreyl.glytrack.domain.model;

import java.util.Objects;
import java.util.Optional;

public class Entry {

    private final Long id;
    private final Day day;
    private final Meal meal;
    private final FoodSource source;

    public Entry(Long id, Day day, Meal meal, FoodSource source) {
        if (day == null) {
            throw new IllegalArgumentException("Day boş olamaz");
        }
        if (source == null) {
            throw new IllegalArgumentException("FoodSource boş olamaz");
        }
        this.id = id;
        this.day = day;
        this.meal = meal;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public Day getDay() {
        return day;
    }

    public Optional<Meal> getMeal() {
        return Optional.ofNullable(meal);
    }

    public FoodSource getSource() {
        return source;
    }

    public boolean isExtra() {
        return meal == null;
    }

    public boolean belongsTo(User u) {
        return day.belongsTo(u);
    }

    public double carbs() {
        return source.carbs();
    }

    public double protein() {
        return source.protein();
    }

    public double calories() {
        return source.calories();
    }

    public double glycemicLoad() {
        return source.glycemicLoad();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry entry)) return false;
        return id != null && id.equals(entry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}