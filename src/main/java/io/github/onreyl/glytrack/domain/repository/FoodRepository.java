package io.github.onreyl.glytrack.domain.repository;

import io.github.onreyl.glytrack.domain.model.Food;

import java.util.List;
import java.util.Optional;

public interface FoodRepository {
    Optional<Food> findById(Long id);
    List<Food> findAll();
    List<Food> findByNameContaining(String query);
}
