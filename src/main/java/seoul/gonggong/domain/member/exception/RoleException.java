package seoul.gonggong.domain.member.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class RoleException extends GeneralException {
    private BaseErrorCode baseErrorCode;

    public RoleException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
