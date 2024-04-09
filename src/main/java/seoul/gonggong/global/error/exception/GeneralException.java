package seoul.gonggong.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.dto.ErrorReasonDto;


@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode baseErrorCode;

    public ErrorReasonDto getErrorReason() {
        return this.baseErrorCode.getReason();
    }

    public ErrorReasonDto getErrorReasonHttpStatus() {
        return this.baseErrorCode.getReasonHttpStatus();
    }
}
