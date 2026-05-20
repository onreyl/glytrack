package io.github.onreyl.glytrack.infrastructure.persistence.adapter;

import io.github.onreyl.glytrack.domain.model.Meal;
import io.github.onreyl.glytrack.domain.model.MealType;
import io.github.onreyl.glytrack.domain.repository.MealRepository;
import io.github.onreyl.glytrack.infrastructure.persistence.entity.MealEntity;
import io.github.onreyl.glytrack.infrastructure.persistence.jpa.MealJpaRepository;
import io.github.onreyl.glytrack.infrastructure.persistence.mapper.MealMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MealRepositoryAdapter implements MealRepository {

    private final MealJpaRepository mealJpaRepository;
    private final MealMapper mapper;

    public MealRepositoryAdapter(MealJpaRepository mealJpaRepository, MealMapper mapper) {
        this.mealJpaRepository = mealJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Meal> findByDayIdAndType(Long dayId, MealType type) {
        return mealJpaRepository.findByDayIdAndType(dayId, type).map(mapper::toDomain);
    }

    @Override
    public Meal save(Meal meal) {
        MealEntity mealEntity = mapper.toEntity(meal);
        MealEntity saved = mealJpaRepository.save(mealEntity);
        return mapper.toDomain(saved);
    }
}
