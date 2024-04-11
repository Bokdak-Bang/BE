package seoul.gonggong.appllication.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoul.gonggong.appllication.member.service.dto.request.MemberSignUpRequest;
import seoul.gonggong.domain.member.Member;
import seoul.gonggong.domain.member.service.MemberAppender;
import seoul.gonggong.domain.member.service.MemberFormatter;
import seoul.gonggong.domain.member.service.MemberModifier;
import seoul.gonggong.domain.member.service.MemberReader;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberReader memberReader;
    private final MemberAppender memberAppender;
    private final MemberModifier memberModifier;
    private final MemberFormatter memberFormatter;

    @Transactional
    public void signUp(MemberSignUpRequest memberSignUpRequest) {
        memberReader.readByEmail(memberSignUpRequest.email());
        memberReader.readByNickName(memberSignUpRequest.nickname());

        Member member = memberSignUpRequest.toDomain();
        memberAppender.createMember( member);
    }






}
