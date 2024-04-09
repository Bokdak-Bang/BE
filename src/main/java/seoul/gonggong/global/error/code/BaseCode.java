package seoul.gonggong.global.error.code;


import seoul.gonggong.global.error.dto.ReasonDto;

public interface BaseCode {
    public ReasonDto getReason();

    public ReasonDto getReasonHttpStatus();
}
