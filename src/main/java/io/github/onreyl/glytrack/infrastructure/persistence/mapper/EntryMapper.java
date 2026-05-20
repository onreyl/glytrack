package io.github.onreyl.glytrack.infrastructure.persistence.mapper;

import io.github.onreyl.glytrack.domain.model.*;
import io.github.onreyl.glytrack.infrastructure.persistence.entity.EntryEntity;
import org.springframework.stereotype.Component;

@Component
public class EntryMapper {

    private final DayMapper dayMapper;
    private final MealMapper mealMapper;
    private final FoodMapper foodMapper;

    public EntryMapper(DayMapper dayMapper, MealMapper mealMapper, FoodMapper foodMapper) {
        this.dayMapper = dayMapper;
        this.mealMapper = mealMapper;
        this.foodMapper = foodMapper;
    }

    public Entry toDomain(EntryEntity e) {
        FoodSource source;
        if (e.getFood() != null) {
            source = new CatalogFood(foodMapper.toDomain(e.getFood()), e.getGrams());
        } else {
            source = new ManualFood(
                    e.getManualName(),
                    e.getGrams(),
                    e.getManualCarbs(),
                    e.getManualProtein(),
                    e.getManualCalories(),
                    e.getManualGi()
            );
        }

        Meal meal = e.getMeal() != null ? mealMapper.toDomain(e.getMeal()) : null;

        return new Entry(e.getId(), dayMapper.toDomain(e.getDay()), meal, source);
    }

    public EntryEntity toEntity(Entry entry) {
        EntryEntity e = new EntryEntity();
        e.setId(entry.getId());
        e.setDay(dayMapper.toEntity(entry.getDay()));
        e.setMeal(entry.getMeal().map(mealMapper::toEntity).orElse(null));
        e.setGrams(entry.getSource().grams());

        switch (entry.getSource()) {
            case CatalogFood cf -> e.setFood(foodMapper.toEntity(cf.food()));
            case ManualFood mf -> {
                e.setManualName(mf.name());
                e.setManualCarbs(mf.carbs());
                e.setManualProtein(mf.protein());
                e.setManualCalories(mf.calories());
                e.setManualGi(mf.gi());
            }
        }
        return e;
    }
}