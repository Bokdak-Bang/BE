package seoul.gonggong.domain.agent.dto.request;

import seoul.gonggong.domain.agent.application.AgentMapper;
import seoul.gonggong.domain.agent.domain.AgentEntity;
import seoul.gonggong.domain.agent.domain.ContactInfo;

public record JoinAgentRequest(
        String email,
        String username,
        String password,
        String checkPassword,
        String area,
        String businessName,
        String phoneNumber,
        String address
) {
    public static AgentEntity toEntity(JoinAgentRequest joinAgentRequest) {
        ContactInfo contactInfo = new ContactInfo(joinAgentRequest.area, joinAgentRequest.businessName(), joinAgentRequest.phoneNumber(), joinAgentRequest.address);
        return AgentMapper.joinRequestToAgentEntity(
                joinAgentRequest.email, joinAgentRequest.username, joinAgentRequest.password, contactInfo);
    }
}
