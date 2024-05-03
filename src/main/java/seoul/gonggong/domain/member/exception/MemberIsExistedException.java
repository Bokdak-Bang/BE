package seoul.gonggong.domain.member.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class MemberIsExistedException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public MemberIsExistedException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
