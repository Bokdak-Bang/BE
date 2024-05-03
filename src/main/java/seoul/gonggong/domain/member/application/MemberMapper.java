package seoul.gonggong.domain.member.application;

import seoul.gonggong.domain.member.domain.MemberEntity;
import seoul.gonggong.domain.member.domain.Role;
import seoul.gonggong.domain.member.dto.request.JoinRequest;

public class MemberMapper {
    public static MemberEntity joinRequestToMemberEntity(String email, String username, String password) {
        return MemberEntity.of(null,
                email,
                username,
                password,
                Role.getEnumRoleFrosmStringRole(String.valueOf(Role.USER))
        );
    }

    public static MemberEntity loginRequestToMemberEntity(Long id,String email,String username, String password) {
        return MemberEntity.of(id,
                email,
                username,
                password,
                Role.getEnumRoleFrosmStringRole(String.valueOf(Role.USER))
        );
    }



}
