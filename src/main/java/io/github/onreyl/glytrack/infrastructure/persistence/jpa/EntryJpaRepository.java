package io.github.onreyl.glytrack.infrastructure.persistence.jpa;

import io.github.onreyl.glytrack.infrastructure.persistence.entity.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EntryJpaRepository extends JpaRepository<EntryEntity, Long> {

    @Query("SELECT e FROM EntryEntity e WHERE e.id = :id AND e.day.user.id = :userId")
    Optional<EntryEntity> findByIdForUser(@Param("id") Long id, @Param("userId") Long userId);

    List<EntryEntity> findByDayId(Long dayId);
}