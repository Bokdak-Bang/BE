package seoul.gonggong.infra.jpa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.user.User;
import seoul.gonggong.domain.user.UserRepository;
import seoul.gonggong.infra.jpa.user.repository.MemberJpaRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberMapper memberMapper;

    @Override
    public Optional<User> findById(Long memberId) {
        return memberJpaRepository.findById(memberId).map(memberMapper::toDomain);
    }

    @Override
    public User save(User user) {
        return memberMapper.toDomain(memberJpaRepository.save(memberMapper.toEntity(user)));
    }
}
