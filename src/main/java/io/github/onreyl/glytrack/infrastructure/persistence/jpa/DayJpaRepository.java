package io.github.onreyl.glytrack.infrastructure.persistence.jpa;

import io.github.onreyl.glytrack.infrastructure.persistence.entity.DayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DayJpaRepository extends JpaRepository<DayEntity, Long> {

    Optional<DayEntity> findByUserIdAndDate(Long userId, LocalDate date);
}
