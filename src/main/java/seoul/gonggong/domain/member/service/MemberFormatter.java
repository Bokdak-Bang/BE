package seoul.gonggong.domain.member.service;

import seoul.gonggong.appllication.member.service.dto.response.MemberResponse;

public interface MemberFormatter {
    MemberResponse format(Long id);

    MemberResponse format(String email);
}
