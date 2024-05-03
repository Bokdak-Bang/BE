package seoul.gonggong.domain.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import seoul.gonggong.global.BaseEntity;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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
    private Role role;

    public static MemberEntity of(Long id, String email, String username, String password,Role role) {
        return new MemberEntity(id, email, username, password, role);
    }

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }

}
