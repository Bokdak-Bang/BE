package seoul.gonggong.domain.member.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seoul.gonggong.domain.member.application.MemberService;
import seoul.gonggong.domain.member.dto.request.JoinRequest;
import seoul.gonggong.domain.member.dto.request.LoginRequest;
import seoul.gonggong.global.ApiResponse;
import seoul.gonggong.global.jwt.dto.TokenInfo;

@RestController
@RequiredArgsConstructor
public class MemberApi {
    private final MemberService memberService;
    @PostMapping("/auth/sign")
    public ApiResponse<String> signMember(@Valid @RequestBody JoinRequest joinRequest) {
        memberService.signMember(joinRequest);
        return ApiResponse.onSuccess("회원가입이 완료되었습니다.");
    }

    @PostMapping("/auth/login")
    public ApiResponse<TokenInfo> loginMember(@Valid @RequestBody LoginRequest loginRequest) {
        return ApiResponse.onSuccess(memberService.login(loginRequest));
    }
}
