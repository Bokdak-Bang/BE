package seoul.gonggong.global.error.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;

public class InvalidValueException extends GeneralException{
    private BaseErrorCode baseErrorCode;

    public InvalidValueException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
