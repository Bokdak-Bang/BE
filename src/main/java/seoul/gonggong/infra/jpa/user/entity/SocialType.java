package seoul.gonggong.infra.jpa.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import seoul.gonggong.domain.user.exception.OAuthException;
import java.util.Arrays;
import static seoul.gonggong.global.error.status.ErrorStatus.INVALID_OAuth;

@RequiredArgsConstructor
@Getter
public enum SocialType {
    KAKAO("KAKAO");

    private final String socialType;
    public static SocialType getEnumSocialTypeFromStringSocialType(String socialType) {
        return Arrays.stream(values())
                .filter(social -> social.socialType.equals(socialType))
                .findFirst()
                .orElseThrow(() -> new OAuthException(INVALID_OAuth));
    }
}
