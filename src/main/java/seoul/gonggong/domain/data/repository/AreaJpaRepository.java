package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Area;

@Repository
public interface AreaJpaRepository extends JpaRepository<Area, Long> {
}
