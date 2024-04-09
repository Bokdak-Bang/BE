package seoul.gonggong.global.error.code;


import seoul.gonggong.global.error.dto.ErrorReasonDto;

public interface BaseErrorCode {
    public ErrorReasonDto getReason();

    public ErrorReasonDto getReasonHttpStatus();
}
