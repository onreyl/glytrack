package io.github.onreyl.glytrack.infrastructure.persistence.adapter;

import io.github.onreyl.glytrack.domain.model.Entry;
import io.github.onreyl.glytrack.domain.repository.EntryRepository;
import io.github.onreyl.glytrack.infrastructure.persistence.entity.EntryEntity;
import io.github.onreyl.glytrack.infrastructure.persistence.jpa.EntryJpaRepository;
import io.github.onreyl.glytrack.infrastructure.persistence.mapper.EntryMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EntryRepositoryAdapter implements EntryRepository {

    private final EntryJpaRepository jpaRepository;
    private final EntryMapper mapper;

    public EntryRepositoryAdapter(EntryJpaRepository jpaRepository, EntryMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Entry> findByIdForUser(Long id, Long userId) {
        return jpaRepository.findByIdForUser(id, userId).map(mapper::toDomain);
    }

    @Override
    public List<Entry> findByDayId(Long dayId) {
        return jpaRepository.findByDayId(dayId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public Entry save(Entry entry) {
        EntryEntity saved = jpaRepository.save(mapper.toEntity(entry));
        return mapper.toDomain(saved);
    }

    @Override
    public void delete(Entry entry) {
        jpaRepository.deleteById(entry.getId());
    }
}