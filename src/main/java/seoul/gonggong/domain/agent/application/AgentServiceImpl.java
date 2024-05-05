package seoul.gonggong.domain.agent.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import seoul.gonggong.domain.agent.domain.AgentEntity;
import seoul.gonggong.domain.agent.dto.request.ContactInfoRequest;
import seoul.gonggong.domain.agent.dto.request.JoinAgentRequest;
import seoul.gonggong.domain.agent.repository.AgentJpaRepository;
import seoul.gonggong.domain.member.domain.MemberEntity;
import seoul.gonggong.domain.member.dto.request.JoinRequest;
import seoul.gonggong.domain.member.dto.request.LoginRequest;
import seoul.gonggong.domain.member.dto.response.LoginResponse;
import seoul.gonggong.domain.member.dto.response.TokenDto;
import seoul.gonggong.domain.member.exception.MemberIsExistedException;
import seoul.gonggong.domain.member.exception.MemberNotFoundException;
import seoul.gonggong.domain.member.exception.PasswordInvalidException;
import seoul.gonggong.global.jwt.TokenProvider;

import static seoul.gonggong.global.error.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService{
    private final PasswordEncoder passwordEncoder;
    private final AgentJpaRepository agentJpaRepository;
    private final TokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Override
    public void signAgent(JoinAgentRequest joinAgentRequest) {
        if (!joinAgentRequest.password().equals(joinAgentRequest.checkPassword())) {
            throw new PasswordInvalidException(PASSWORD_IS_INVALID);
        }
        agentJpaRepository.findByEmail(joinAgentRequest.email())
                .ifPresent(s -> {
                    throw new MemberIsExistedException(MEMBER_IS_ALREADY_EXIST);
                });

        saveAgentAndEncodePassWord(JoinAgentRequest.toEntity(joinAgentRequest));
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Long id = agentJpaRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND))
                .getId();

        UsernamePasswordAuthenticationToken authenticationToken = loginRequest.toAuthentication();
        System.out.println("authenticationToken = " + authenticationToken.getAuthorities());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        System.out.println("authentication = " + authentication);
        TokenDto tokenDto = jwtTokenProvider.generateTokenDto(authentication);

//        // 4. RefreshToken 저장
//        RefreshToken refreshToken = RefreshToken.builder()
//                .key(authentication.getName())
//                .value(tokenDto.getRefreshToken())
//                .build();
//
//        refreshTokenRepository.save(refreshToken);

        // 5. 토큰 발급
        return LoginResponse.of(tokenDto, id);

    }

    public void saveAgentAndEncodePassWord(AgentEntity agentEntity) {
        agentEntity.encodePassword(passwordEncoder);
        agentJpaRepository.save(agentEntity);
    }

}
