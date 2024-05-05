package seoul.gonggong.domain.member.application;

import seoul.gonggong.domain.member.domain.MemberEntity;
import seoul.gonggong.domain.member.dto.request.JoinRequest;
import seoul.gonggong.domain.member.dto.request.LoginRequest;
import seoul.gonggong.domain.member.dto.request.MemberRequest;
import seoul.gonggong.domain.member.dto.response.LoginResponse;
import seoul.gonggong.domain.member.dto.response.MemberResponse;
import seoul.gonggong.domain.member.dto.response.TokenDto;

public interface MemberService {
    void signMember(JoinRequest joinRequest);

    LoginResponse login(LoginRequest loginRequest);

    MemberResponse findMemberInfoById(Long memberId);

    MemberResponse findMemberWithId(Long memberId);

    MemberResponse updateMember(MemberRequest memberRequest,Long id);
}
