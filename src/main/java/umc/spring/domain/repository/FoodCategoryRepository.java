package umc.spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.entity.FoodCategory;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
