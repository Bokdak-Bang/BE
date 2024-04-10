package seoul.gonggong.domain.member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
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

    public static Member of(Long id, String nickname, String email, String password, String profileImg,
                            Integer age, String city, String socialId,
                            String refreshToken, String socialType, String role) {
        return new Member(
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
