package fi.haagahelia.codingLesson.repo;


import org.springframework.data.jpa.repository.JpaRepository;


import fi.haagahelia.codingLesson.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}