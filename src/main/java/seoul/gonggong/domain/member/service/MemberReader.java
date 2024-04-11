package seoul.gonggong.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoul.gonggong.domain.member.Member;
import seoul.gonggong.domain.member.MemberRepository;
import seoul.gonggong.domain.member.exception.MemberException;

import static seoul.gonggong.global.error.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
public class MemberReader {
    private final MemberRepository memberRepository;
    public Member getMemberWithID(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new MemberException(MEMBER_NOT_FOUND));
    }

}
