package seoul.gonggong.domain.data.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "education")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer elementarySchool;
    private Integer middleSchool;
    private Integer highSchool;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;

}
