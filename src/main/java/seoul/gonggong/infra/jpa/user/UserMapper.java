package seoul.gonggong.infra.jpa.user;

import org.springframework.stereotype.Component;
import seoul.gonggong.domain.user.User;
import seoul.gonggong.infra.jpa.user.entity.Role;
import seoul.gonggong.infra.jpa.user.entity.SocialType;
import seoul.gonggong.infra.jpa.user.entity.UserEntity;

@Component
public class UserMapper {
    public User toDomain(UserEntity userEntity) {

        return User.of(
                userEntity.getId(),
                userEntity.getNickname(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getProfileImg(),
                userEntity.getAge(),
                userEntity.getCity(),
                userEntity.getSocialId(),
                userEntity.getRefreshToken(),
                String.valueOf(userEntity.getSocialType()),
                String.valueOf(userEntity.getRole())
        );
    }

    public UserEntity toEntity(User user) {
        return UserEntity.of(
                user.getId(),
                user.getEmail(),
                user.getNickname(),
                user.getPassword(),
                user.getProfileImg(),
                user.getAge(),
                user.getCity(),
                user.getSocialId(),
                user.getRefreshToken(),
                SocialType.getEnumSocialTypeFromStringSocialType(user.getSocialType()),
                Role.getEnumRoleFromStringRole(user.getRole())
        );
    }
}
