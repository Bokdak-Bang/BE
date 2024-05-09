package seoul.gonggong.domain.agent.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import seoul.gonggong.domain.member.domain.Authority;

@Entity
@Table(name = "agents")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class AgentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, unique = true)
    private String email;

    @Column(length = 45)
    private String nickname;

    @Column(length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Embedded
    private ContactInfo contactInfo;

    public static AgentEntity of(Long id, String email, String nickname, String password, Authority authority,
                                 ContactInfo contactInfo) {
        return new AgentEntity(id, email, nickname, password, authority, contactInfo);
    }

    public static AgentEntity of(Long id, String email, String nickname, String password, Authority authority) {
        return AgentEntity.builder()
                .id(id)
                .email(email)
                .nickname(nickname)
                .password(password)
                .authority(authority)
                .build();
    }

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }

    public void updateNickName(String nickname) {
        this.nickname = nickname;
    }
    public void updatePassword(String password) {
        this.password = password;
    }
}

