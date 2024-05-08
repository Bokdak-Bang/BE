package seoul.gonggong.domain.data.domain;

import jakarta.persistence.*;
import lombok.*;
import seoul.gonggong.domain.member.domain.MemberEntity;

@Entity
@Table(name = "member_area")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberAreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;

    public static MemberAreaEntity of(Long id, MemberEntity member, Area area) {
        return new MemberAreaEntity(id, member, area);
    }
}
