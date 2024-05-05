package seoul.gonggong.domain.member.application;

import seoul.gonggong.domain.member.dto.response.MemberResponse;

public interface MemberFormatter {
    MemberResponse format(Long memberId);
}
