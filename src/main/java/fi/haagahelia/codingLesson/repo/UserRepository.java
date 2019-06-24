package fi.haagahelia.codingLesson.repo;

import fi.haagahelia.codingLesson.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findByName(String name);
}
