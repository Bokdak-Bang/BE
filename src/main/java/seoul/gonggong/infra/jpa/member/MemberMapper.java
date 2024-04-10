package seoul.gonggong.infra.jpa.member;

import org.springframework.stereotype.Component;
import seoul.gonggong.domain.member.Member;
import seoul.gonggong.infra.jpa.member.entity.MemberEntity;
import seoul.gonggong.infra.jpa.member.entity.Role;
import seoul.gonggong.infra.jpa.member.entity.SocialType;

@Component
public class MemberMapper {
    public Member toDomain(MemberEntity memberEntity) {

        return Member.of(
                memberEntity.getId(),
                memberEntity.getNickname(),
                memberEntity.getEmail(),
                memberEntity.getPassword(),
                memberEntity.getProfileImg(),
                memberEntity.getAge(),
                memberEntity.getCity(),
                memberEntity.getSocialId(),
                memberEntity.getRefreshToken(),
                String.valueOf(memberEntity.getSocialType()),
                String.valueOf(memberEntity.getRole())
        );
    }

    public MemberEntity toEntity(Member member) {
        return MemberEntity.of(
                member.getId(),
                member.getEmail(),
                member.getNickname(),
                member.getPassword(),
                member.getProfileImg(),
                member.getAge(),
                member.getCity(),
                member.getSocialId(),
                member.getRefreshToken(),
                SocialType.getEnumSocialTypeFromStringSocialType(member.getSocialType()),
                Role.getEnumRoleFromStringRole(member.getRole())
        );
    }
}
