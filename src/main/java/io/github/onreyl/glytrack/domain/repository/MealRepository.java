package io.github.onreyl.glytrack.domain.repository;

import io.github.onreyl.glytrack.domain.model.Meal;
import io.github.onreyl.glytrack.domain.model.MealType;

import java.util.Optional;

public interface MealRepository {
    Optional<Meal> findByDayIdAndType(Long dayId, MealType type);
    Meal save(Meal meal);
}
