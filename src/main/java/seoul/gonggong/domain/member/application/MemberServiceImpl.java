package seoul.gonggong.domain.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoul.gonggong.domain.member.domain.MemberEntity;
import seoul.gonggong.domain.member.dto.request.JoinRequest;
import seoul.gonggong.domain.member.dto.request.LoginRequest;
import seoul.gonggong.domain.member.exception.MemberIsExistedException;
import seoul.gonggong.domain.member.exception.MemberNotFoundException;
import seoul.gonggong.domain.member.exception.PasswordInvalidException;
import seoul.gonggong.domain.member.repository.MemberJpaRepository;
import seoul.gonggong.global.jwt.JwtTokenProvider;
import seoul.gonggong.global.jwt.dto.TokenInfo;

import static seoul.gonggong.global.error.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
    private final MemberJpaRepository memberJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void signMember(JoinRequest joinRequest) {
        if (!joinRequest.password().equals(joinRequest.checkPassword())) {
            throw new PasswordInvalidException(PASSWORD_IS_INVALID);
        }
        memberJpaRepository.findByEmail(joinRequest.email())
                .ifPresent(s -> {
                            throw new MemberIsExistedException(MEMBER_IS_ALREADY_EXIST);
                        }
                );
        saveMemberAndEncodePassWord(
                JoinRequest.toEntity(joinRequest)
        );
    }

    @Override
    public TokenInfo login(LoginRequest loginRequest) {
        MemberEntity findMemberEntity = memberJpaRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));

        UsernamePasswordAuthenticationToken authentication = loginRequest.toAuthentication();
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
        return tokenInfo;

    }

    public void saveMemberAndEncodePassWord(MemberEntity memberEntity) {
        memberEntity.encodePassword(passwordEncoder);
        memberJpaRepository.save(memberEntity);
    }
}
