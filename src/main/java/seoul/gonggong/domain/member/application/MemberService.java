package seoul.gonggong.domain.member.application;

import org.springframework.security.core.userdetails.UserDetails;
import seoul.gonggong.domain.member.dto.request.JoinRequest;
import seoul.gonggong.domain.member.dto.request.LoginRequest;
import seoul.gonggong.global.jwt.dto.TokenInfo;

import java.util.Map;

public interface MemberService {
    void signMember(JoinRequest joinRequest);

    TokenInfo login(LoginRequest loginRequest);
}
