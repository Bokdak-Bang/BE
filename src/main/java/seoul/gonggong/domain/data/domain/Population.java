package seoul.gonggong.domain.data.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "population")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double onePersonHouseWholeRate;
    private Double youthPeople;
    private Double productivePeople;
    private Double oldPeople;
    private Double onePersonHouseWholeRateMean;
    private Double youthPeopleMean;
    private Double productivePeopleMean;
    private Double oldPeopleMean;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;
}
