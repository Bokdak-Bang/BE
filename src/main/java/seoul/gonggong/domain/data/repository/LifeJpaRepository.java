package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Life;

@Repository
public interface LifeJpaRepository extends JpaRepository<Life, Long> {
}
