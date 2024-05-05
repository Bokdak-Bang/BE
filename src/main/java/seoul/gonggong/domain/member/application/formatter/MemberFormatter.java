//package seoul.gonggong.domain.member.application.formatter;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import seoul.gonggong.domain.member.application.MemberService;
//import seoul.gonggong.domain.member.domain.MemberEntity;
//import seoul.gonggong.domain.member.dto.response.MemberResponse;
//
//@Service
//@RequiredArgsConstructor
//public class MemberFormatter implements seoul.gonggong.domain.member.application.MemberFormatter {
//    private final MemberService memberService;
//    @Override
//    public MemberResponse format(Long memberId) {
//        final MemberResponse memberResponse = memberService.findMemberWithId(memberId);
//        return MemberResponse.of(
//                memberResponse.id(),
//                memberResponse.email(),
//                memberResponse.nickname()
//        );
//    }
//
//
//}
