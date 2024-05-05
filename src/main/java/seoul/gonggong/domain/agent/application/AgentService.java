package seoul.gonggong.domain.agent.application;

import seoul.gonggong.domain.agent.dto.request.ContactInfoRequest;
import seoul.gonggong.domain.agent.dto.request.JoinAgentRequest;
import seoul.gonggong.domain.member.dto.request.JoinRequest;
import seoul.gonggong.domain.member.dto.request.LoginRequest;
import seoul.gonggong.domain.member.dto.response.LoginResponse;

public interface AgentService {
    void signAgent(JoinAgentRequest joinAgentRequest);
    LoginResponse login(LoginRequest loginRequest);
}
