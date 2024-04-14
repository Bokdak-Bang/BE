package seoul.gonggong.domain.user;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long memberId);
    User save(User user);


}
