package io.github.onreyl.glytrack.domain.model;

import java.util.Objects;

public class Meal {

    private final Long id;
    private final Day day;
    private final MealType type;

    public Meal(Long id, Day day, MealType type) {
        if (day == null) {
            throw new IllegalArgumentException("Day boş olamaz");
        }
        if (type == null) {
            throw new IllegalArgumentException("MealType boş olamaz");
        }
        this.id = id;
        this.day = day;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Day getDay() {
        return day;
    }

    public MealType getType() {
        return type;
    }

    public boolean belongsTo(User u) {
        return day.belongsTo(u);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meal meal)) return false;
        return id != null && id.equals(meal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}