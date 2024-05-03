package seoul.gonggong.domain.member.dto.request;

import seoul.gonggong.domain.member.application.MemberMapper;
import seoul.gonggong.domain.member.domain.MemberEntity;

public record JoinRequest(
        String email,
        String username,
        String password,
        String checkPassword
) {
    public static MemberEntity toEntity(JoinRequest joinRequest) {
        return MemberMapper.joinRequestToMemberEntity(
                joinRequest.email, joinRequest.username, joinRequest.password
        );
    }
}

