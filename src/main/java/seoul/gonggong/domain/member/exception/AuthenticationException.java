package seoul.gonggong.domain.member.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class AuthenticationException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public AuthenticationException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
