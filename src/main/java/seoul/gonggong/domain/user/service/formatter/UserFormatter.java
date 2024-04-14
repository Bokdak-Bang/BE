package seoul.gonggong.domain.user.service.formatter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoul.gonggong.appllication.user.service.dto.response.UserResponse;
import seoul.gonggong.domain.user.User;
import seoul.gonggong.domain.user.service.UserReader;

@Service
@RequiredArgsConstructor
public class UserFormatter implements seoul.gonggong.domain.user.service.UserFormatter {
    private final UserReader userReader;

    @Override
    public UserResponse format(String email){
        final User user = userReader.readByEmail(email);
        return UserResponse.of(user);
    }

    @Override
    public UserResponse format(Long memberId) {
        final User user = userReader.read(memberId);
        return UserResponse.of(user);
    }
}
