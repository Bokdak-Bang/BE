package seoul.gonggong.domain.data.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "security")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer accident;
    private Integer criminal;
    private Integer lifeSecurity;
    private Integer suicide;
    private Integer fire;
    private Integer cctv;
    private Integer accidentMean;
    private Integer criminalMean;
    private Integer lifeSecurityMean;
    private Integer suicideMean;
    private Integer fireMean;
    private Integer cctvMean;

    private Double totalScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;

}
