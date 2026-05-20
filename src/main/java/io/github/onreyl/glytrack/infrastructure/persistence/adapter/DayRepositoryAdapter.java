package io.github.onreyl.glytrack.infrastructure.persistence.adapter;

import io.github.onreyl.glytrack.domain.model.Day;
import io.github.onreyl.glytrack.domain.repository.DayRepository;
import io.github.onreyl.glytrack.infrastructure.persistence.entity.DayEntity;
import io.github.onreyl.glytrack.infrastructure.persistence.jpa.DayJpaRepository;
import io.github.onreyl.glytrack.infrastructure.persistence.mapper.DayMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class DayRepositoryAdapter implements DayRepository {

    private final DayJpaRepository jpaRepository;
    private final DayMapper mapper;

    public DayRepositoryAdapter(DayJpaRepository jpaRepository, DayMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Day> findByUserIdAndDate(Long userId, LocalDate date) {
        return jpaRepository.findByUserIdAndDate(userId, date).map(mapper::toDomain);
    }

    @Override
    public Day save(Day day) {
        DayEntity entity = mapper.toEntity(day);
        DayEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }
}