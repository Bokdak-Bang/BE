package seoul.gonggong.appllication.user.service.dto.request;

import seoul.gonggong.domain.user.User;

public record UserSignUpRequest(
        String email,
        String password,
        String nickname,
        Integer age,
        String city
) {
    public User toDomain() {
        return User.of(
                null,
                nickname,
                email,
                password,
                null,
                age,
                city,
                null,
                null,
                null,
                null
        );
    }
}
