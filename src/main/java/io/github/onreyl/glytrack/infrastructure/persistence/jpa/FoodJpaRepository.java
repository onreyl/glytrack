package io.github.onreyl.glytrack.infrastructure.persistence.jpa;

import io.github.onreyl.glytrack.infrastructure.persistence.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodJpaRepository extends JpaRepository<FoodEntity, Long> {

    List<FoodEntity> findByNameContainingIgnoreCase(String query);
}