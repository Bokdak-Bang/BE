package seoul.gonggong.appllication.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoul.gonggong.appllication.user.service.dto.request.UserSignUpRequest;
import seoul.gonggong.domain.user.User;
import seoul.gonggong.domain.user.service.UserAppender;
import seoul.gonggong.domain.user.service.UserReader;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserReader userReader;
    private final UserAppender userAppender;

    @Transactional
    public void signUp(UserSignUpRequest userSignUpRequest) {
//        memberReader.readByEmail(memberSignUpRequest.email());
//        memberReader.readByNickName(memberSignUpRequest.nickname());

        User user = userSignUpRequest.toDomain();
        userAppender.createUser(user);
    }






}
