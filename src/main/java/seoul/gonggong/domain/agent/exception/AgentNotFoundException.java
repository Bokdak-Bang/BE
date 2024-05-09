package seoul.gonggong.domain.agent.exception;

import seoul.gonggong.global.error.code.BaseErrorCode;
import seoul.gonggong.global.error.exception.GeneralException;

public class AgentNotFoundException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public AgentNotFoundException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
