package seoul.gonggong.infra.jpa.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.member.Member;
import seoul.gonggong.domain.member.MemberRepository;
import seoul.gonggong.infra.jpa.member.repository.MemberJpaRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberMapper memberMapper;

    @Override
    public Optional<Member> findById(Long memberId) {

        return Optional.empty();
    }

    @Override
    public Member save(Member member) {
        return memberMapper.toDomain(
                memberJpaRepository.save(memberMapper.toEntity(member))
        );
    }
}
