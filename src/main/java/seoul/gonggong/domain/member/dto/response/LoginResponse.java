package seoul.gonggong.domain.member.dto.response;

public record LoginResponse(
        Long id,
        String grantType,
        String accessToken
) {
    public static LoginResponse of(TokenDto tokenDto, Long id) {
        return new LoginResponse(id, tokenDto.getGrantType(), tokenDto.getAccessToken());
    }
}
