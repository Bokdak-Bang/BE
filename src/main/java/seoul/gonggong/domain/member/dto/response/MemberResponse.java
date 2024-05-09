package seoul.gonggong.domain.member.dto.response;

import seoul.gonggong.domain.member.domain.MemberEntity;

public record MemberResponse(
        Long id,
        String email,
        String username
) {
    public static MemberResponse of(Long id,String email,String username) {
        return new MemberResponse(id, email,username);
    }
}
