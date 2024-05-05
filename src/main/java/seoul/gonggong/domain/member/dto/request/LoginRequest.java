package seoul.gonggong.domain.member.dto.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import seoul.gonggong.domain.member.application.MemberMapper;
import seoul.gonggong.domain.member.domain.MemberEntity;

public record LoginRequest(
        String email,
        String password
) {
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
