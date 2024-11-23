package umc.spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.entity.Mission;
import umc.spring.domain.entity.Store;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    boolean existsByStoreAndDescription(Store store, String description);
}