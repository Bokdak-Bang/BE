package seoul.gonggong.domain.member.dto.request;

import seoul.gonggong.domain.agent.domain.AgentEntity;
import seoul.gonggong.domain.member.application.MemberMapper;
import seoul.gonggong.domain.member.domain.MemberEntity;

public record MemberRequest(
        String username,
        String password,
        String passwordCheck
) {
    public static MemberEntity toEntity(MemberRequest memberRequest, Long id, String email) {
        return MemberMapper.memberRequestToMemberEntity(
                id, email, memberRequest.username, memberRequest.password()
        );
    }

    public static AgentEntity toAgentEntity(MemberRequest memberRequest, Long id, String email) {
        return MemberMapper.memberRequestToAgentEntity(
                id, email, memberRequest.username, memberRequest.password()
        );
    }
}
