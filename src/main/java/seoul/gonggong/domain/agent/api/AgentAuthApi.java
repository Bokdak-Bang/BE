package seoul.gonggong.domain.agent.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seoul.gonggong.domain.agent.application.AgentService;
import seoul.gonggong.domain.agent.dto.request.ContactInfoRequest;
import seoul.gonggong.domain.agent.dto.request.JoinAgentRequest;
import seoul.gonggong.domain.member.dto.request.JoinRequest;
import seoul.gonggong.domain.member.dto.request.LoginRequest;
import seoul.gonggong.domain.member.dto.response.LoginResponse;
import seoul.gonggong.global.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AgentAuthApi {
    private final AgentService agentService;

    @PostMapping("/sign/agents")
    public ApiResponse<String> signMember(@Valid @RequestBody JoinAgentRequest joinAgentRequest) {
        agentService.signAgent(joinAgentRequest);
        return ApiResponse.onSuccess("공인중개사 회원가입이 완료되었습니다.");
    }

//    @PostMapping("/login/agents")
//    public ApiResponse<LoginResponse> loginAgent(@Valid @RequestBody LoginRequest loginRequest) {
//        return ApiResponse.onSuccess(agentService.login(loginRequest));
//    }
}
