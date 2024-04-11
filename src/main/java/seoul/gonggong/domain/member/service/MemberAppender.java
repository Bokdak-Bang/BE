package seoul.gonggong.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoul.gonggong.appllication.member.service.dto.response.MemberResponse;
import seoul.gonggong.domain.member.Member;
import seoul.gonggong.domain.member.MemberRepository;
import seoul.gonggong.domain.member.exception.MemberException;

import static seoul.gonggong.global.error.status.ErrorStatus.MEMBER_IS_NOT_SAVE;

@Service
@RequiredArgsConstructor
public class MemberAppender {
    private final MemberRepository memberRepository;
    private final MemberFormatter memberFormatter;

    @Transactional
    public Member createMember(Member member) {
        memberRepository.save(member);
        return memberRepository.save(member).orElseThrow(()-> new MemberException(MEMBER_IS_NOT_SAVE));
    }

}
