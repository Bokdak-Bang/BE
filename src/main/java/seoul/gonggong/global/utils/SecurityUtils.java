    package seoul.gonggong.global.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import seoul.gonggong.domain.member.exception.AuthenticationException;

import static seoul.gonggong.global.error.status.ErrorStatus.NO_AUTHENTICATION_INFO;

@RequiredArgsConstructor
public class SecurityUtils {
    public static Long getCurrentMemberID(){
        final Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if (authentication == null || authentication.getName() == null) {
            throw new AuthenticationException(NO_AUTHENTICATION_INFO);
        }
        return Long.parseLong(authentication.getName());
    }
}
