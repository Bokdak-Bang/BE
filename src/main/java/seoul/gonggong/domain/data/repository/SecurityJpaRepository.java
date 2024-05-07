package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.domain.Security;

import java.util.Optional;

@Repository
public interface SecurityJpaRepository extends JpaRepository<Security, Long> {
    Optional<Security> findByArea(Area area);
}
