package io.github.onreyl.glytrack.infrastructure.persistence.mapper;

import io.github.onreyl.glytrack.domain.model.Meal;
import io.github.onreyl.glytrack.infrastructure.persistence.entity.MealEntity;
import org.springframework.stereotype.Component;

@Component
public class MealMapper {
    private final DayMapper dayMapper;

    public MealMapper(DayMapper dayMapper) {
        this.dayMapper = dayMapper;
    }

    public Meal toDomain(MealEntity mealEntity) {
        return new Meal(
                mealEntity.getId(),
                dayMapper.toDomain(mealEntity.getDay()),
                mealEntity.getType()
        );
    }

    public MealEntity toEntity(Meal meal) {
        return new MealEntity(
                meal.getId(),
                meal.getType(),
                dayMapper.toEntity(meal.getDay())
        );
    }

}
