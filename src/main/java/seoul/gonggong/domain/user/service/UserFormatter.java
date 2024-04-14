package seoul.gonggong.domain.user.service;

import seoul.gonggong.appllication.user.service.dto.response.UserResponse;

public interface UserFormatter {
    UserResponse format(Long id);

    UserResponse format(String email);
}
