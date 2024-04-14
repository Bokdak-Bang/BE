package seoul.gonggong.global.jwt.exception;

import seoul.gonggong.global.error.code.BaseCode;
import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class OAuth2Exception extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public OAuth2Exception(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
