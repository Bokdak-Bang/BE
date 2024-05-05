package seoul.gonggong.domain.member.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import seoul.gonggong.global.error.exception.InvalidValueException;

import java.util.Arrays;

import static seoul.gonggong.global.error.status.ErrorStatus.INVALID_ROLE;

//@RequiredArgsConstructor
//@Getter
public enum Role {
//    ROLE_USER("ROLE_USER"),
//    ROLE_AGENT("ROLE_AGENT");
//
//    private final String stringRole;
//
//    public static Role getEnumRoleFrosmStringRole(String stringRole) {
//        return Arrays.stream(values())
//                .filter(role -> role.stringRole.equals(stringRole))
//                .findFirst()
//                .orElseThrow(() -> new InvalidValueException(INVALID_ROLE));
//    }
    ROLE_USER, ROLE_AGENT
}
