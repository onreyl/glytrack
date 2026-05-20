package io.github.onreyl.glytrack.infrastructure.persistence.mapper;

import io.github.onreyl.glytrack.domain.model.Food;
import io.github.onreyl.glytrack.infrastructure.persistence.entity.FoodEntity;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {

    public Food toDomain(FoodEntity entity) {
        return new Food(
                entity.getId(),
                entity.getName(),
                entity.getCarbsPer100g(),
                entity.getProteinPer100g(),
                entity.getCaloriesPer100g(),
                entity.getGi()
        );
    }

    public FoodEntity toEntity(Food food) {
        return new FoodEntity(
                food.id(),
                food.name(),
                food.carbsPer100g(),
                food.proteinPer100g(),
                food.caloriesPer100g(),
                food.gi()
        );
    }
}