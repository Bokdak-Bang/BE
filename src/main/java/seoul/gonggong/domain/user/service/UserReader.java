package seoul.gonggong.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoul.gonggong.domain.user.User;
import seoul.gonggong.domain.user.UserRepository;
import seoul.gonggong.domain.user.exception.UserNotFoundException;

import static seoul.gonggong.global.error.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
public class UserReader {
    private final UserRepository memberRepository;
    public User getMemberWithID(Long userId) {
        return memberRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }

}
