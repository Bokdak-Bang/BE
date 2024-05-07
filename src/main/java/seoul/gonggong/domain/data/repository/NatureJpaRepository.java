package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Nature;

@Repository
public interface NatureJpaRepository extends JpaRepository<Nature,Long> {
}
