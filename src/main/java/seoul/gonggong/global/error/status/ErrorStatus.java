package seoul.gonggong.global.error.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.dto.ErrorReasonDto;


@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    //기본(전역) 에러
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"COMMON_500", "서버에서 요청을 처리 하는 동안 오류가 발생했습니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON_400", "입력 값이 잘못된 요청 입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON_401", "인증이 필요 합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON_403", "금지된 요청 입니다."),

    //User 관련 에러
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_001", "사용자를 찾을 수 없습니다."),
    MEMBER_IS_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "MEMBER_002", "동일한 이메일을 가지고 있는 사용자가 존재합니다."),
    PASSWORD_IS_INVALID(HttpStatus.BAD_REQUEST,"MEMBER_003","비밀번호가 일치하지 않습니다."),
    INVALID_REGION(HttpStatus.FORBIDDEN,"ENUM_001","유효하지 않은 Region입니다."),

    //JWT 관련 에러
    JWT_TOKEN_IS_WRONG(HttpStatus.BAD_REQUEST,"JWT_001","JWT 토큰이 잘못되었습니다."),
    TOKEN_IS_EXPIRED(HttpStatus.BAD_REQUEST,"JWT_002","잘못된 JWT 서명입니다."),
    EXPIRED_JWT(HttpStatus.BAD_REQUEST,"JWT_003","만료된 JWT 토큰입니다."),
    UNSUPPORTED_JWT(HttpStatus.BAD_REQUEST, "JWt_004", "지원되지 않은 JWT 토큰입니다."),
    UNAUTHORIZED_TOKEN(HttpStatus.UNAUTHORIZED, "JWT_005", "권한 정보가 없는 토큰 입니다."),

    //Data 관련 에러
    DATA_IS_WRONG(HttpStatus.BAD_REQUEST,"DATA_001","데이터를 처리하는데 오류가 발생하였습니다."),
    AREA_NOT_FOUND(HttpStatus.NOT_FOUND,"DATA_002","요청하신 지역을 찾지 못하였습니다."),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "DATA_003", "데이터를 찾지 못하였습니다."),

    //Auth 관련 에러
    NO_AUTHENTICATION_INFO(HttpStatus.NOT_FOUND, "AUTH_001", "Security Context 에 인증 정보가 없습니다.."),

    //Body 에러
    INVALID_BODY(HttpStatus.BAD_REQUEST, "BODY_ERROR", "Body가 올바르지 않습니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }


}
