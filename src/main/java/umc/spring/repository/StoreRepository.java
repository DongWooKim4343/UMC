package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
