package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Education;

@Repository
public interface EducationJpaRepository extends JpaRepository<Education, Long> {
}
