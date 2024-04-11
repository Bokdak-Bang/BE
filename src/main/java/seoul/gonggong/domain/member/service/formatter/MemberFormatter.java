package seoul.gonggong.domain.member.service.formatter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoul.gonggong.appllication.member.service.dto.response.MemberResponse;
import seoul.gonggong.domain.member.Member;
import seoul.gonggong.domain.member.service.MemberReader;

@Service
@RequiredArgsConstructor
public class MemberFormatter implements seoul.gonggong.domain.member.service.MemberFormatter {
    private final MemberReader memberReader;

    @Override
    public MemberResponse format(String email){
        final Member member = memberReader.readByEmail(email);
        return MemberResponse.of(member);
    }

    @Override
    public MemberResponse format(Long memberId) {
        final Member member = memberReader.read(memberId);
        return MemberResponse.of(member);
    }
}
