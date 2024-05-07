package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.domain.Residence;

import java.util.Optional;


@Repository
public interface ResidenceJpaRepository extends JpaRepository<Residence, Long> {
    Optional<Residence> findByArea(Area area);
}
