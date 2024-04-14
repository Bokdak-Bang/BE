package seoul.gonggong.domain.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private String profileImg;
    private Integer age;
    private String city;
    private String socialId;
    private String refreshToken;
    private String socialType;
    private String role;

    public static User of(Long id, String nickname, String email, String password, String profileImg,
                          Integer age, String city, String socialId,
                          String refreshToken, String socialType, String role) {
        return new User(
                id,
                nickname,
                email,
                password,
                profileImg,
                age,
                city,
                socialId,
                refreshToken,
                socialType,
                role);
    }
}
