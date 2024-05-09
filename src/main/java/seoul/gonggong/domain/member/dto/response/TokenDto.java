package seoul.gonggong.domain.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
//    private Long id;
    private String role;
    private String grantType;
    private String accessToken;
//    private String refreshToken;
    private Long accessTokenExpiresIn;
}
