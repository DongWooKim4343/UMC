package umc.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.practice.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
