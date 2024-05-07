package seoul.gonggong.domain.data.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "residence")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Residence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer landPrice;
    private Double landArea;
    private Double expansionRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;
}

