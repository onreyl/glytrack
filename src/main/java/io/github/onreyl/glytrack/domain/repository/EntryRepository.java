package io.github.onreyl.glytrack.domain.repository;

import io.github.onreyl.glytrack.domain.model.Entry;

import java.util.List;
import java.util.Optional;

public interface EntryRepository {
    Optional<Entry> findByIdForUser(Long id, Long userId);
    List<Entry> findByDayId(Long dayId);
    Entry save(Entry entry);
    void delete(Entry entry);
}
