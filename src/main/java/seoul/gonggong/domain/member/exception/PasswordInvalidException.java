package seoul.gonggong.domain.member.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class PasswordInvalidException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public PasswordInvalidException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
