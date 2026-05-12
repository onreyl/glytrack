package io.github.onreyl.glytrack.domain.repository;

import io.github.onreyl.glytrack.domain.model.Day;

import java.time.LocalDate;
import java.util.Optional;

public interface DayRepository {
    Optional<Day> findByUserIdAndDate(Long userId, LocalDate date);
    Day save(Day day);
}
