package seoul.gonggong.domain.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class DataException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public DataException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
