package io.github.onreyl.glytrack.infrastructure.persistence.mapper;

import io.github.onreyl.glytrack.domain.model.User;
import io.github.onreyl.glytrack.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserEntity entity) {
        return new User(
            entity.getId(),
            entity.getEmail(),
            entity.getPasswordHash(),
            entity.getTargetCalories(),
            entity.getTargetCarbs(),
            entity.getTargetGl()
        );
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(
            user.getId(),
            user.getEmail(),
            user.getPasswordHash(),
            user.getTargetCalories(),
            user.getTargetCarbs(),
            user.getTargetGl()
        );
    }
}
