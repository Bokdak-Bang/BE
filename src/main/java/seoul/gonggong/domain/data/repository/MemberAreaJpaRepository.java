package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.domain.MemberAreaEntity;
import seoul.gonggong.domain.member.domain.MemberEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberAreaJpaRepository extends JpaRepository<MemberAreaEntity, Long> {
    List<MemberAreaEntity> findByMemberId(Long memberId);
    Optional<MemberAreaEntity> findByMemberAndArea(MemberEntity member, Area area);
}
