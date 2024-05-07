package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.domain.Life;

import java.util.Optional;

@Repository
public interface LifeJpaRepository extends JpaRepository<Life, Long> {
    Optional<Life> findByArea(Area area);
}
