package seoul.gonggong.domain.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.domain.WelfareCulture;

import java.util.Optional;

@Repository
public interface WelfareCultureJpaRepository extends JpaRepository<WelfareCulture, Long> {
    Optional<WelfareCulture> findByArea(Area area);
}
