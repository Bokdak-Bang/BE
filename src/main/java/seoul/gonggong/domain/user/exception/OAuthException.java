package seoul.gonggong.domain.user.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class OAuthException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public OAuthException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
