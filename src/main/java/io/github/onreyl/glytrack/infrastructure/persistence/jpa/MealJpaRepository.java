package io.github.onreyl.glytrack.infrastructure.persistence.jpa;

import io.github.onreyl.glytrack.domain.model.MealType;
import io.github.onreyl.glytrack.infrastructure.persistence.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealJpaRepository extends JpaRepository<MealEntity, Long> {
    Optional<MealEntity> findByDayIdAndType(Long dayId, MealType type);
}
