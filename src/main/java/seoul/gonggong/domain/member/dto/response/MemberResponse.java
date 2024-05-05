package seoul.gonggong.domain.member.dto.response;

import seoul.gonggong.domain.member.domain.MemberEntity;

public record MemberResponse(
        Long id,
        String email,
        String nickname
) {
    public static MemberResponse of(Long id,String email,String nickname) {
        return new MemberResponse(id, email,nickname);
    }
}
