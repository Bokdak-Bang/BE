package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.domain.Nature;

import java.util.Optional;

@Repository
public interface NatureJpaRepository extends JpaRepository<Nature,Long> {
    Optional<Nature> findByArea(Area area);
}
