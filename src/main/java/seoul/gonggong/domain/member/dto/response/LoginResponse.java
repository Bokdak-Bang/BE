package seoul.gonggong.domain.member.dto.response;

public record LoginResponse(
        Long id,
        String username,
        String role,
        String grantType,
        String accessToken
) {
    public static LoginResponse of(String username,TokenDto tokenDto, Long id) {
        return new LoginResponse(id, username, tokenDto.getRole(), tokenDto.getGrantType(), tokenDto.getAccessToken());
    }

}
