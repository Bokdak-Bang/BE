package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.domain.Education;

import java.util.Optional;

@Repository
public interface EducationJpaRepository extends JpaRepository<Education, Long> {
    Optional<Education> findByArea(Area area);
}
