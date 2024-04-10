package seoul.gonggong.appllication.member.service.dto.request;

import seoul.gonggong.domain.member.Member;

public record MemberSignUpRequest(
        String email,
        String password,
        String nickname,
        Integer age,
        String city
) {
    public Member toDomain() {
        return Member.of(
                null,
                nickname,
                email,
                password,
                null,
                age,
                city,
                null,
                null,
                null,
                null
        );
    }
}
