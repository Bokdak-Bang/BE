package seoul.gonggong.domain.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import seoul.gonggong.global.error.exception.InvalidValueException;

import java.util.Arrays;

import static seoul.gonggong.global.error.status.ErrorStatus.INVALID_ROLE;

@RequiredArgsConstructor
@Getter
public enum Role {
    USER("USER"),
    AGENT("AGENT");

    private final String stringRole;

    public static Role getEnumRoleFrosmStringRole(String stringRole) {
        return Arrays.stream(values())
                .filter(role -> role.stringRole.equals(stringRole))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_ROLE));
    }

}
