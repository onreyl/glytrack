package io.github.onreyl.glytrack.infrastructure.persistence.adapter;

import io.github.onreyl.glytrack.domain.model.Food;
import io.github.onreyl.glytrack.domain.repository.FoodRepository;
import io.github.onreyl.glytrack.infrastructure.persistence.jpa.FoodJpaRepository;
import io.github.onreyl.glytrack.infrastructure.persistence.mapper.FoodMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FoodRepositoryAdapter implements FoodRepository {

    private final FoodJpaRepository jpaRepository;
    private final FoodMapper mapper;

    public FoodRepositoryAdapter(FoodJpaRepository jpaRepository, FoodMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Food> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Food> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Food> findByNameContaining(String query) {
        return jpaRepository.findByNameContainingIgnoreCase(query).stream()
                .map(mapper::toDomain)
                .toList();
    }
}