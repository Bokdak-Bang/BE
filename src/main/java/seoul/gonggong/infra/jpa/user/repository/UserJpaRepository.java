package seoul.gonggong.infra.jpa.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import seoul.gonggong.infra.jpa.user.entity.UserEntity;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);
}
