package io.github.onreyl.glytrack.infrastructure.persistence.adapter;

import io.github.onreyl.glytrack.domain.model.User;
import io.github.onreyl.glytrack.domain.repository.UserRepository;
import io.github.onreyl.glytrack.infrastructure.persistence.entity.UserEntity;
import io.github.onreyl.glytrack.infrastructure.persistence.jpa.UserJpaRepository;
import io.github.onreyl.glytrack.infrastructure.persistence.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private final UserMapper mapper;

    public UserRepositoryAdapter(UserJpaRepository jpaRepository, UserMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }
}
