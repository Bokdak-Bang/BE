package seoul.gonggong.domain.data.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "education")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double onePersonHouseHoleRate;
    private Double youthPeople;
    private Double productivePeople;
    private Double oldPeople;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;
}
