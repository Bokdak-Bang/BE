package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.MemberAreaEntity;

import java.util.List;

@Repository
public interface MemberAreaJpaRepository extends JpaRepository<MemberAreaEntity, Long> {
    List<MemberAreaEntity> findByMemberId(Long memberId);
}
