package seoul.gonggong.domain.member.application.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoul.gonggong.domain.member.domain.MemberEntity;
import seoul.gonggong.domain.member.repository.MemberJpaRepository;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberJpaRepository.findByEmail(username)
            .map(this::createUserDetails)
            .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    // DB 에 User 값이 존재한다면 UserDetails 객체로 만들어서 리턴
    private UserDetails createUserDetails(MemberEntity member) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getAuthority().toString());

        return new User(
            String.valueOf(member.getId()),
            member.getPassword(),
            Collections.singleton(grantedAuthority)
        );
    }
}
