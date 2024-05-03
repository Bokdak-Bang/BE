package seoul.gonggong.domain.member.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class TokenException extends GeneralException {
    private BaseErrorCode baseErrorCode;

    public TokenException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
