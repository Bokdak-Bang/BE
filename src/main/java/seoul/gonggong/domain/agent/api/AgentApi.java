package seoul.gonggong.domain.agent.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seoul.gonggong.domain.agent.application.AgentService;
import seoul.gonggong.domain.member.dto.request.MemberRequest;
import seoul.gonggong.domain.member.dto.response.MemberResponse;
import seoul.gonggong.global.ApiResponse;
import seoul.gonggong.global.utils.SecurityUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agents")
public class AgentApi {
    private final AgentService agentService;

    @GetMapping("/my-page")
    public ApiResponse<MemberResponse> getMyPage() {
        return ApiResponse.onSuccess(agentService.findAgentWithId(SecurityUtil.getCurrentMemberId()));
    }

    @PatchMapping("/my-page")
    public ApiResponse<MemberResponse> updateMyPage(@RequestBody MemberRequest memberRequest) {
        return ApiResponse.onSuccess(agentService.updateAgent(memberRequest, SecurityUtil.getCurrentMemberId()));
    }

}
