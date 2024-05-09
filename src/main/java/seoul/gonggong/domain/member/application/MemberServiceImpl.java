package seoul.gonggong.domain.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoul.gonggong.domain.agent.domain.AgentEntity;
import seoul.gonggong.domain.agent.repository.AgentJpaRepository;
import seoul.gonggong.domain.member.domain.MemberEntity;
import seoul.gonggong.domain.member.dto.request.JoinRequest;
import seoul.gonggong.domain.member.dto.request.LoginRequest;
import seoul.gonggong.domain.member.dto.request.MemberRequest;
import seoul.gonggong.domain.member.dto.response.LoginResponse;
import seoul.gonggong.domain.member.dto.response.MemberResponse;
import seoul.gonggong.domain.member.dto.response.TokenDto;
import seoul.gonggong.domain.member.exception.MemberIsExistedException;
import seoul.gonggong.domain.member.exception.MemberNotFoundException;
import seoul.gonggong.domain.member.exception.PasswordInvalidException;
import seoul.gonggong.domain.member.repository.MemberJpaRepository;
import seoul.gonggong.global.jwt.TokenProvider;
import static seoul.gonggong.global.error.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
    private final MemberJpaRepository memberJpaRepository;
    private final AgentJpaRepository agentJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
//    private final MemberFormatter memberFormatter;



    @Override
    public void signMember(JoinRequest joinRequest) {
        if (!joinRequest.password().equals(joinRequest.checkPassword())) {
            throw new PasswordInvalidException(PASSWORD_IS_INVALID);
        }
        agentJpaRepository.findByEmail(joinRequest.email())
                .ifPresent(s -> {
                    throw new MemberIsExistedException(EMAIL_IS_EXIST);
                });

        memberJpaRepository.findByEmail(joinRequest.email())
                .ifPresent(s -> {
                    throw new MemberIsExistedException(MEMBER_IS_ALREADY_EXIST);
                });


        saveMemberAndEncodePassWord(JoinRequest.toEntity(joinRequest));
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Long id = null;
        String role = null;
        String nickname = null;

        if (memberJpaRepository.existsByEmail(loginRequest.email())) {
            MemberEntity memberEntity = memberJpaRepository.findByEmail(loginRequest.email()).orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
            id = memberEntity.getId();
            role = String.valueOf(memberEntity.getAuthority());
            nickname = memberEntity.getNickname();
        }
        if (agentJpaRepository.existsByEmail(loginRequest.email())) {
            AgentEntity agentEntity = agentJpaRepository.findByEmail(loginRequest.email()).orElseThrow(() -> new MemberNotFoundException(AGENT_NOT_FOUND));
            id= agentEntity.getId();
            role= String.valueOf(agentEntity.getAuthority());
            nickname = agentEntity.getNickname();
        }

        UsernamePasswordAuthenticationToken authenticationToken = loginRequest.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = jwtTokenProvider.generateTokenDto(authentication);

//        // 4. RefreshToken 저장
//        RefreshToken refreshToken = RefreshToken.builder()
//                .key(authentication.getName())
//                .value(tokenDto.getRefreshToken())
//                .build();
//
//        refreshTokenRepository.save(refreshToken);

        // 5. 토큰 발급
        return LoginResponse.of(nickname, tokenDto, id);
    }

    @Override
    public MemberResponse findMemberInfoById(Long memberId) {
        return memberJpaRepository.findById(memberId)
                .map(member -> MemberResponse.of(member.getId(), member.getEmail(), member.getNickname(), member.getPassword()))
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
    }

    @Override
    public MemberResponse findMemberWithId(Long memberId) {
        return memberJpaRepository.findById(memberId)
                .map(member -> MemberResponse.of(member.getId(), member.getEmail(), member.getNickname(),member.getPassword()))
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
    }

    public void saveMemberAndEncodePassWord(MemberEntity memberEntity) {
        memberEntity.encodePassword(passwordEncoder);
        memberJpaRepository.save(memberEntity);
    }

    @Override
    public MemberResponse updateMember(MemberRequest memberRequest,Long id) {
        MemberEntity memberEntity = memberJpaRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));

        MemberEntity updateMember = MemberRequest.toEntity(
                memberRequest, memberEntity.getId(), memberEntity.getEmail()
        );
        saveMemberAndEncodePassWord(updateMember);

        return MemberResponse.of(updateMember.getId(), updateMember.getEmail(), updateMember.getNickname(), memberEntity.getPassword());
    }

}
