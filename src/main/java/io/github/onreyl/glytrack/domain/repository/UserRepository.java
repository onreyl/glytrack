package io.github.onreyl.glytrack.domain.repository;

import io.github.onreyl.glytrack.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User save(User user);
}
