package seoul.gonggong.domain.agent.application;

import seoul.gonggong.domain.agent.domain.AgentEntity;
import seoul.gonggong.domain.agent.domain.ContactInfo;
import seoul.gonggong.domain.member.domain.Authority;
import seoul.gonggong.domain.member.domain.MemberEntity;

public class AgentMapper {
    public static AgentEntity joinRequestToAgentEntity(String email, String username, String password, ContactInfo contactInfo) {
        return AgentEntity.of(null,
                email,
                username,
                password,
                Authority.ROLE_AGENT,
                contactInfo
                );
    }
}
