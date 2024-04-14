package seoul.gonggong.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoul.gonggong.domain.user.User;
import seoul.gonggong.domain.user.UserRepository;
import seoul.gonggong.domain.user.service.formatter.UserFormatter;

@Service
@RequiredArgsConstructor
public class UserAppender {
    private final UserRepository userRepository;
    private final UserFormatter userFormatter;

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

}
