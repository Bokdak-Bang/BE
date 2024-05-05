package seoul.gonggong.domain.agent.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ContactInfo {

    @Column(length = 100)
    private String area;

    @Column(length = 100)
    private String businessName;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 255)
    private String address;
}
