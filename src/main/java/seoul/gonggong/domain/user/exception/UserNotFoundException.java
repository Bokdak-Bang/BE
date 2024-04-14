package seoul.gonggong.domain.user.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class UserNotFoundException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public UserNotFoundException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
