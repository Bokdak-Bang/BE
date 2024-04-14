package seoul.gonggong.appllication.user.service.dto.response;

import seoul.gonggong.domain.user.User;

public record UserResponse(
        Long id,
        String email,
        String nickname,
        String socialType
) {
    public static UserResponse of(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getNickname(),
                user.getSocialType()
        );
    }

}
