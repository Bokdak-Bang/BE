package seoul.gonggong.infra.jpa.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seoul.gonggong.infra.jpa.member.entity.MemberEntity;
import seoul.gonggong.infra.jpa.member.entity.SocialType;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByEmail(String email);
}
