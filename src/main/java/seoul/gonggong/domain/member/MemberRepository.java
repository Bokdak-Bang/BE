package seoul.gonggong.domain.member;

import seoul.gonggong.infra.jpa.member.entity.MemberEntity;
import seoul.gonggong.infra.jpa.member.entity.SocialType;

import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(Long memberId);
    Member save(Member member);


}
