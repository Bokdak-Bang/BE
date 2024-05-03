package seoul.gonggong.domain.member.dto.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import seoul.gonggong.domain.member.application.MemberMapper;
import seoul.gonggong.domain.member.domain.MemberEntity;

public record LoginRequest(
        String email,
        String password
) {
    public static MemberEntity toEntity(LoginRequest loginRequest,Long id,String username) {
        return MemberMapper.loginRequestToMemberEntity(id,
                loginRequest.email, username,loginRequest.password
        );
    }
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
