package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.domain.Population;
import seoul.gonggong.domain.data.domain.WelfareCulture;

import java.util.Optional;

@Repository
public interface PopulationJpaRepository extends JpaRepository<Population, Long> {
    Optional<Population> findByArea(Area area);
}