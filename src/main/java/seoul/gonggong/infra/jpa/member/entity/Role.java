package seoul.gonggong.infra.jpa.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import seoul.gonggong.domain.member.exception.OAuthException;
import seoul.gonggong.domain.member.exception.RoleException;

import java.util.Arrays;

import static seoul.gonggong.global.error.status.ErrorStatus.INVALID_OAuth;
import static seoul.gonggong.global.error.status.ErrorStatus.INVALID_ROLE;

@RequiredArgsConstructor
@Getter
public enum Role {
    GUEST("GUEST"),
    USER("USER"),
    AGENT("AGENT");

    private final String role;

    public static Role getEnumRoleFromStringRole(String role) {
        return Arrays.stream(values())
                .filter(r -> r.role.equals(role))
                .findFirst()
                .orElseThrow(() -> new RoleException(INVALID_ROLE));
    }
}
