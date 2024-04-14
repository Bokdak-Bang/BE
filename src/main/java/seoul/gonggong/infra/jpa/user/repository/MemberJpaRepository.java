package seoul.gonggong.infra.jpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seoul.gonggong.infra.jpa.user.entity.MemberEntity;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByEmail(String email);
}
