package seoul.gonggong.infra.jpa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.user.User;
import seoul.gonggong.domain.user.UserRepository;
import seoul.gonggong.infra.jpa.user.repository.MemberJpaRepository;
import seoul.gonggong.infra.jpa.user.repository.UserJpaRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findById(Long memberId) {
        return userJpaRepository.findById(memberId).map(userMapper::toDomain);
    }

    @Override
    public User save(User user) {
        return userMapper.toDomain(userJpaRepository.save(userMapper.toEntity(user)));
    }
}
