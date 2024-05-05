package seoul.gonggong.domain.member.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import seoul.gonggong.global.BaseEntity;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberEntity extends BaseEntity {
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

    public static MemberEntity of(Long id, String email, String username, String password,Authority authority) {
        return new MemberEntity(id, email, username, password, authority);
    }

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }

}
