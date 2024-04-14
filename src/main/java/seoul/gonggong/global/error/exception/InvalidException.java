package seoul.gonggong.global.error.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;

public class InvalidException extends GeneralException{
    private BaseErrorCode baseErrorCode;

    public InvalidException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
