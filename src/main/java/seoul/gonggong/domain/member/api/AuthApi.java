package seoul.gonggong.domain.member.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seoul.gonggong.domain.member.application.MemberService;
import seoul.gonggong.domain.member.dto.request.JoinRequest;
import seoul.gonggong.domain.member.dto.request.LoginRequest;
import seoul.gonggong.domain.member.dto.response.LoginResponse;
import seoul.gonggong.domain.member.dto.response.MemberResponse;
import seoul.gonggong.domain.member.dto.response.TokenDto;
import seoul.gonggong.global.ApiResponse;
import seoul.gonggong.global.utils.SecurityUtil;

@RestController
@RequiredArgsConstructor
public class AuthApi {
    private final MemberService memberService;
    @PostMapping("/auth/sign")
    public ApiResponse<String> signMember(@Valid @RequestBody JoinRequest joinRequest) {
        memberService.signMember(joinRequest);
        return ApiResponse.onSuccess("회원가입이 완료되었습니다.");
    }

    @PostMapping("/auth/login")
    public ApiResponse<LoginResponse> loginMember(@Valid @RequestBody LoginRequest loginRequest) {
        return ApiResponse.onSuccess(memberService.login(loginRequest));
    }

    @GetMapping("/mypage")
    public ApiResponse<MemberResponse> findMemberInfoById() {
        return ApiResponse.onSuccess(memberService.findMemberInfoById(SecurityUtil.getCurrentMemberId()));
    }
}
