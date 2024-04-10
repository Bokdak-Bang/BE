package seoul.gonggong.domain.member.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class MemberException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public MemberException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
