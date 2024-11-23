package umc.spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
