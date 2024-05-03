package seoul.gonggong.domain.member.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class MemberNotFoundException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public MemberNotFoundException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
