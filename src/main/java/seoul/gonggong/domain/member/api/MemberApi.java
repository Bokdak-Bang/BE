package seoul.gonggong.domain.member.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seoul.gonggong.domain.member.application.MemberService;
import seoul.gonggong.domain.member.dto.request.MemberRequest;
import seoul.gonggong.domain.member.dto.response.MemberResponse;
import seoul.gonggong.global.ApiResponse;
import seoul.gonggong.global.utils.SecurityUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApi {
    private final MemberService memberService;
    @GetMapping("")
    public ApiResponse<MemberResponse> getMyPage() {
        return ApiResponse.onSuccess(memberService.findMemberWithId(SecurityUtil.getCurrentMemberId()));
    }

    @PatchMapping
    public ApiResponse<MemberResponse> updateMyPage(@RequestBody MemberRequest memberRequest) {
        return ApiResponse.onSuccess(memberService.updateMember(memberRequest, SecurityUtil.getCurrentMemberId()));
    }
}
