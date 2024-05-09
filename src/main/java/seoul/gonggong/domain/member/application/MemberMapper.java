package seoul.gonggong.domain.member.application;

import seoul.gonggong.domain.agent.domain.AgentEntity;
import seoul.gonggong.domain.member.domain.Authority;
import seoul.gonggong.domain.member.domain.MemberEntity;
import seoul.gonggong.domain.member.domain.Role;
import seoul.gonggong.domain.member.dto.request.JoinRequest;

public class MemberMapper {

    public static MemberEntity joinRequestToMemberEntity(String email, String username, String password) {
        return MemberEntity.of(null,
                email,
                username,
                password,
                Authority.ROLE_USER
        );
    }

    public static MemberEntity loginRequestToMemberEntity(Long id,String email,String username, String password) {
        return MemberEntity.of(id,
                email,
                username,
                password,
                Authority.ROLE_USER
        );
    }

    public static MemberEntity memberRequestToMemberEntity(Long id, String email,String username, String password) {
        return MemberEntity.of(id,
                email,
                username,
                password,
                Authority.ROLE_USER
        );
    }

    public static AgentEntity memberRequestToAgentEntity(Long id, String email,String nickname, String password) {
        return AgentEntity.of(id,
                email,
                nickname,
                password,
                Authority.ROLE_AGENT
        );
    }
}
