package seoul.gonggong.appllication.member.service.dto.response;

import seoul.gonggong.domain.member.Member;

public record MemberResponse(
        Long id,
        String email,
        String nickname,
        String socialType
) {
    public static MemberResponse of(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getEmail(),
                member.getNickname(),
                member.getSocialType()
        );
    }

}
