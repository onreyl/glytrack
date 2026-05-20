package io.github.onreyl.glytrack.infrastructure.persistence.mapper;

import io.github.onreyl.glytrack.domain.model.Day;
import io.github.onreyl.glytrack.infrastructure.persistence.entity.DayEntity;
import org.springframework.stereotype.Component;

@Component
public class DayMapper {

    private final UserMapper userMapper;

    public DayMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Day toDomain(DayEntity entity) {
        return new Day(
                entity.getId(),
                userMapper.toDomain(entity.getUser()),
                entity.getDate()
        );
    }

    public DayEntity toEntity(Day day) {
        return new DayEntity(
                day.getId(),
                userMapper.toEntity(day.getUser()),
                day.getDate()
        );
    }
}