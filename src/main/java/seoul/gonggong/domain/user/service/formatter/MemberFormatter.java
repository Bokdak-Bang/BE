package seoul.gonggong.domain.user.service.formatter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoul.gonggong.appllication.user.service.dto.response.MemberResponse;
import seoul.gonggong.domain.user.User;
import seoul.gonggong.domain.user.service.UserReader;

@Service
@RequiredArgsConstructor
public class UserFormatter implements seoul.gonggong.domain.user.service.MemberFormatter {
    private final UserReader userReader;

    @Override
    public MemberResponse format(String email){
        final User user = memberReader.readByEmail(email);
        return MemberResponse.of(user);
    }

    @Override
    public MemberResponse format(Long memberId) {
        final User user = memberReader.read(memberId);
        return MemberResponse.of(user);
    }
}
