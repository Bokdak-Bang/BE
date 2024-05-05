package seoul.gonggong.domain.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seoul.gonggong.domain.agent.domain.AgentEntity;
import seoul.gonggong.domain.member.domain.MemberEntity;

import java.util.Optional;

public interface AgentJpaRepository extends JpaRepository<AgentEntity, Long> {
    Optional<AgentEntity> findByEmail(String email);
}
