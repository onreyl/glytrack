package io.github.onreyl.glytrack.application.mapper;

import io.github.onreyl.glytrack.application.dto.FoodResponse;
import io.github.onreyl.glytrack.domain.model.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodDtoMapper {

    public FoodResponse toResponse(Food food) {
        return new FoodResponse(
                food.id(),
                food.name(),
                food.carbsPer100g(),
                food.proteinPer100g(),
                food.caloriesPer100g(),
                food.gi()
        );
    }
}